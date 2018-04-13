/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.datalake.store.implementation;

import com.microsoft.azure.AzureEnvironment;
import com.microsoft.azure.AzureResponseBuilder;
import com.microsoft.azure.credentials.AzureTokenCredentials;
import com.microsoft.azure.management.datalake.store.DataLakeStoreAccounts;
import com.microsoft.azure.management.resources.fluentcore.arm.AzureConfigurable;
import com.microsoft.azure.management.resources.fluentcore.arm.implementation.AzureConfigurableImpl;
import com.microsoft.azure.management.resources.fluentcore.arm.implementation.Manager;
import com.microsoft.azure.management.resources.fluentcore.utils.ProviderRegistrationInterceptor;
import com.microsoft.azure.management.resources.fluentcore.utils.ResourceManagerThrottlingInterceptor;
import com.microsoft.azure.serializer.AzureJacksonAdapter;
import com.microsoft.rest.RestClient;

/**
 * Entry point to Azure Data Lake Store resource management.
 */
public final class DataLakeStoreManager extends Manager<DataLakeStoreManager, DataLakeStoreAccountManagementClientImpl> {
    // Collections
     private DataLakeStoreAccounts dataLakeStoreAccounts;

    private DataLakeStoreManager(RestClient restClient, String subscriptionId) {
        super(
                restClient,
                subscriptionId,
                new DataLakeStoreAccountManagementClientImpl(restClient).withSubscriptionId(subscriptionId)
        );
    }

    /**
     * Creates an instance of DataLakeStoreManager that exposes Data Lake Store resource management API entry points.
     *
     * @param restClient the RestClient to be used for API calls.
     * @param subscriptionId the subscription UUID
     * @return the DataLakeStoreManager
     */
    public static DataLakeStoreManager authenticate(RestClient restClient, String subscriptionId) {
        return new DataLakeStoreManager(restClient, subscriptionId);
    }

    /**
     * Creates an instance of DataLakeStoreManager that exposes Data Lake Store resource management API entry points.
     *
     * @param credentials the credentials to use
     * @param subscriptionId the subscription UUID
     * @return the DataLakeStoreManager
     */
    public static DataLakeStoreManager authenticate(AzureTokenCredentials credentials, String subscriptionId) {
        return new DataLakeStoreManager(
                new RestClient.Builder()
                        .withBaseUrl(credentials.environment(), AzureEnvironment.Endpoint.RESOURCE_MANAGER)
                        .withCredentials(credentials)
                        .withSerializerAdapter(new AzureJacksonAdapter())
                        .withResponseBuilderFactory(new AzureResponseBuilder.Factory())
                        .withInterceptor(new ProviderRegistrationInterceptor(credentials))
                        .withInterceptor(new ResourceManagerThrottlingInterceptor())
                        .build(), subscriptionId);
    }

    /**
     * The interface allowing configurations to be set.
     */
    public interface Configurable extends AzureConfigurable<Configurable> {
        /**
         * Creates an instance of DataLakeStoreManager that exposes Data Lake Store management API entry points.
         *
         * @param credentials the credentials to use
         * @param subscriptionId the subscription UUID
         * @return the interface exposing Data Lake Store management API entry points that work across subscriptions
         */
        DataLakeStoreManager authenticate(AzureTokenCredentials credentials, String subscriptionId);
    }

    /**
     * The implementation for Configurable interface.
     */
    private static final class ConfigurableImpl extends AzureConfigurableImpl<Configurable> implements Configurable {
        public DataLakeStoreManager authenticate(AzureTokenCredentials credentials, String subscriptionId) {
            return DataLakeStoreManager.authenticate(buildRestClient(credentials), subscriptionId);
        }
    }

    /**
     * Get a Configurable instance that can be used to create DataLakeStoreManager with optional configuration.
     *
     * @return the instance allowing configurations
     */
    public static Configurable configure() {
        return new DataLakeStoreManager.ConfigurableImpl();
    }

    /**
     * @return the Data Lake Store account management API entry point
     */
    public DataLakeStoreAccounts dataLakeStoreAccounts() {
        if (dataLakeStoreAccounts == null) {
            dataLakeStoreAccounts = new DataLakeStoreAccountsImpl(this);
        }
        return dataLakeStoreAccounts;
    }
}