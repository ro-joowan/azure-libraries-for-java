/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.microsoft.azure.management.batchai.implementation;

import com.microsoft.azure.management.apigeneration.LangDefinition;
import com.microsoft.azure.management.batchai.BatchAICluster;
import com.microsoft.azure.management.batchai.BatchAIFileServer;
import com.microsoft.azure.management.batchai.FileServerReference;
import com.microsoft.azure.management.batchai.ResourceId;
import com.microsoft.azure.management.resources.fluentcore.model.implementation.IndexableWrapperImpl;

/**
 * Represents file server reference.
 */
@LangDefinition
public class BatchAIFileServerImpl extends IndexableWrapperImpl<FileServerReference>
        implements
        BatchAIFileServer,
        BatchAIFileServer.Definition<BatchAICluster.DefinitionStages.WithCreate> {
    private BatchAIClusterImpl parent;

    BatchAIFileServerImpl(FileServerReference inner, BatchAIClusterImpl parent) {
        super(inner);
        this.parent = parent;
    }

    @Override
    public BatchAIFileServerImpl withRelativeMountPath(String mountPath) {
        inner().withRelativeMountPath(mountPath);
        return this;
    }

    @Override
    public BatchAICluster parent() {
        return parent;
    }

    @Override
    public BatchAICluster.DefinitionStages.WithCreate attach() {
        this.parent.attachFileServer(this);
        return parent;
    }

    @Override
    public BatchAIFileServerImpl withMountOptions(String mountOptions) {
        inner().withMountOptions(mountOptions);
        return this;
    }

    @Override
    public BatchAIFileServerImpl withFileServerId(String fileServerId) {
        inner().withFileServer(new ResourceId().withId(parent.id()));
        return this;
    }

    @Override
    public DefinitionStages.WithAttach<BatchAICluster.DefinitionStages.WithCreate> withSourceDirectory(String sourceDirectory) {
        inner().withSourceDirectory(sourceDirectory);
        return this;
    }
}