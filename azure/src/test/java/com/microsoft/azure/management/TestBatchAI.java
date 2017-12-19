/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management;

import com.microsoft.azure.management.batchai.AzureFileShareReference;
import com.microsoft.azure.management.batchai.Cluster;
import com.microsoft.azure.management.batchai.Clusters;
import com.microsoft.azure.management.batchai.VmPriority;
import com.microsoft.azure.management.compute.VirtualMachineSizeTypes;
import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import com.microsoft.azure.management.resources.fluentcore.utils.SdkContext;
import com.microsoft.azure.management.storage.StorageAccount;
import com.microsoft.azure.management.storage.StorageAccounts;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.file.CloudFileShare;
import org.junit.Assert;

/**
 * Test of Batch AI management.
 */
public class TestBatchAI {
    private static final Region region = Region.US_EAST;

    public static class Basic extends TestTemplate<Cluster, Clusters> {
        private StorageAccounts storageAccounts;

        public Basic(StorageAccounts storageAccounts) {
            this.storageAccounts = storageAccounts;
        }

        @Override
        public Cluster createResource(Clusters clusters) throws Exception {
            final String groupName = SdkContext.randomResourceName("rg", 10);
            final String clusterName = SdkContext.randomResourceName("cluster", 15);
            final String saName = SdkContext.randomResourceName("cluster", 15);
            final String shareName = "myfileshare";
            final String shareMountPath = "azurefileshare";
            final String blobFileSystemPath = "myblobsystem";
            final String containerName = "mycontainer";
            final String userName = "tirekicker";

            String storageAccountKey = ensureStorageAccount(storageAccounts, saName, groupName, shareName);
            String connectionString = String.format("DefaultEndpointsProtocol=https;AccountName=%s;AccountKey=%s", saName, storageAccountKey);

            CloudFileShare cloudFileShare = CloudStorageAccount.parse(String.format("DefaultEndpointsProtocol=https;AccountName=%s;AccountKey=%s;EndpointSuffix=core.windows.net",
                    saName, storageAccountKey))
                    .createCloudFileClient()
                    .getShareReference(shareName);
            cloudFileShare.create();

            CloudStorageAccount account = CloudStorageAccount.parse(connectionString);
            CloudBlobClient cloudBlobClient = account.createCloudBlobClient();
            CloudBlobContainer container = cloudBlobClient.getContainerReference(containerName);
            container.createIfNotExists();

            Cluster cluster = clusters.define(clusterName)
                    .withRegion(region)
                    .withNewResourceGroup(groupName)
                    .withVMSize(VirtualMachineSizeTypes.STANDARD_NC6.toString())
                    .withUserName(userName)
                    .withPassword("MyPassword")
                    .withAutoScale(1, 1)
                    .withLowPriority()
                    .defineSetupTask()
                        .withCommandLine("echo Hello World!")
                        .withStdOutErrPath("./outputpath")
                    .attach()
                    .defineAzureFileShare()
                        .withStorageAccountName(saName)
                        .withAzureFileUrl(cloudFileShare.getStorageUri().getPrimaryUri().toString())
                        .withRelativeMountPath(shareMountPath)
                        .withAccountKey(storageAccountKey)
                        .attach()
                    .defineAzureBlobFileSystem()
                        .withStorageAccountName(saName)
                        .withContainerName(containerName)
                        .withRelativeMountPath(blobFileSystemPath)
                        .withAccountKey(storageAccountKey)
                        .attach()
                    .withTag("tag1", "value1")
                    .create();
            Assert.assertEquals("steady", cluster.allocationState().toString());
            Assert.assertEquals(userName, cluster.adminUserName());
            Assert.assertEquals(VmPriority.LOWPRIORITY, cluster.vmPriority());
            Assert.assertEquals(1, cluster.nodeSetup().mountVolumes().azureFileShares().size());
            Assert.assertEquals(shareMountPath, cluster.nodeSetup().mountVolumes().azureFileShares().get(0).relativeMountPath());
            Assert.assertEquals(1, cluster.nodeSetup().mountVolumes().azureBlobFileSystems().size());
            Assert.assertEquals(blobFileSystemPath, cluster.nodeSetup().mountVolumes().azureBlobFileSystems().get(0).relativeMountPath());
            return cluster;
        }

        @Override
        public Cluster updateResource(Cluster cluster) throws Exception {
            cluster.update()
                    .withAutoScale(1, 2, 2)
                    .withTag("tag1", "value2")
                    .apply();
            Assert.assertEquals(2, cluster.scaleSettings().autoScale().maximumNodeCount());
            Assert.assertEquals("value2", cluster.tags().get("tag1"));
            return cluster;
        }

        @Override
        public void print(Cluster resource) {
            printBatchAICluster(resource);
        }
    }

    public static class JobCreate extends TestTemplate<Cluster, Clusters> {

        @Override
        public Cluster createResource(Clusters clusters) throws Exception {
            final String groupName = SdkContext.randomResourceName("rg", 10);
            final String clusterName = SdkContext.randomResourceName("cluster", 15);
            final String userName = "tirekicker";

            Cluster cluster = clusters.define(clusterName)
                    .withRegion(region)
                    .withNewResourceGroup(groupName)
                    .withVMSize(VirtualMachineSizeTypes.STANDARD_NC6.toString())
                    .withUserName(userName)
                    .withPassword("MyPassword")
                    .withAutoScale(1, 1)
                    .create();
            Assert.assertEquals("steady", cluster.allocationState().toString());
            Assert.assertEquals(userName, cluster.adminUserName());
//            cluster.jobs().define("myJob")
//                    .withRegion(Region.US_WEST2)
//                    .withStdOutErrPathPrefix("$AZ_BATCHAI_MOUNT_ROOT/azurefileshare")
//                    .withNodeCount(1)
//                    .
//                    .create();
            return cluster;
        }

        @Override
        public Cluster updateResource(Cluster cluster) throws Exception {
            return cluster;
        }

        @Override
        public void print(Cluster resource) {
            printBatchAICluster(resource);
        }
    }

    private static String ensureStorageAccount(StorageAccounts storageAccounts, String saName, String rgName, String shareName) throws Exception {
        StorageAccount storageAccount = storageAccounts.define(saName)
                .withRegion(region)
                .withNewResourceGroup(rgName)
                .create();

        return storageAccount.getKeys().get(0).value();
    }

    private static void printBatchAICluster(Cluster cluster) {
        StringBuilder info = new StringBuilder();
        info.append("Batch AI Cluster: ").append(cluster.id())
                .append("\n\tName: ").append(cluster.name())
                .append("\n\tResource group: ").append(cluster.resourceGroupName())
                .append("\n\tRegion: ").append(cluster.regionName())
                .append("\n\tTags: ").append(cluster.tags())
                .append("\n\tVM size: ").append(cluster.vmSize())
                .append("\n\tAdmin user name: ").append(cluster.adminUserName())
                .append("\n\tCreation time: ").append(cluster.creationTime());
        if (cluster.nodeSetup() != null && cluster.nodeSetup().mountVolumes() != null && cluster.nodeSetup().mountVolumes().azureFileShares() != null) {
            info.append("\n\tAzure file shares: ");
            for (AzureFileShareReference fileShare : cluster.nodeSetup().mountVolumes().azureFileShares()) {
                info.append("\n\t\tAccount name: ").append(fileShare.accountName())
                    .append("\n\t\tAzure file url: ").append(fileShare.azureFileUrl())
                    .append("\n\t\tRelative mount path: ").append(fileShare.relativeMountPath());
            }
        }
        System.out.println(info.toString());
    }
}