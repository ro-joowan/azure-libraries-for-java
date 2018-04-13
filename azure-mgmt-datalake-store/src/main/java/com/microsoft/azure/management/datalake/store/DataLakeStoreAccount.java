/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.datalake.store;

import com.microsoft.azure.management.apigeneration.Fluent;
import com.microsoft.azure.management.datalake.store.implementation.DataLakeStoreAccountInner;
import com.microsoft.azure.management.datalake.store.implementation.DataLakeStoreManager;
import com.microsoft.azure.management.resources.fluentcore.arm.models.GroupableResource;
import com.microsoft.azure.management.resources.fluentcore.arm.models.Resource;
import com.microsoft.azure.management.resources.fluentcore.model.Appliable;
import com.microsoft.azure.management.resources.fluentcore.model.Creatable;
import com.microsoft.azure.management.resources.fluentcore.model.Refreshable;
import com.microsoft.azure.management.resources.fluentcore.model.Updatable;

/**
 * An immutable client-side representation of an Azure Data Lake Store account.
 */
@Fluent
public interface DataLakeStoreAccount extends
        GroupableResource<DataLakeStoreManager, DataLakeStoreAccountInner>,
        Refreshable<DataLakeStoreAccount>,
        Updatable<DataLakeStoreAccount.Update> {

    /**
     * @return The Key Vault encryption identity, if any.
     */
    EncryptionIdentity identity();

    /**
     * The unique identifier associated with this Data Lake Store account.
     */
    @JsonProperty(value = "properties.accountId", access = JsonProperty.Access.WRITE_ONLY)
    private UUID accountId;

    /**
     * The provisioning status of the Data Lake Store account. Possible values
     * include: 'Failed', 'Creating', 'Running', 'Succeeded', 'Patching',
     * 'Suspending', 'Resuming', 'Deleting', 'Deleted', 'Undeleting',
     * 'Canceled'.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private DataLakeStoreAccountStatus provisioningState;

    /**
     * The state of the Data Lake Store account. Possible values include:
     * 'Active', 'Suspended'.
     */
    @JsonProperty(value = "properties.state", access = JsonProperty.Access.WRITE_ONLY)
    private DataLakeStoreAccountState state;

    /**
     * The account creation time.
     */
    @JsonProperty(value = "properties.creationTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime creationTime;

    /**
     * The account last modified time.
     */
    @JsonProperty(value = "properties.lastModifiedTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime lastModifiedTime;

    /**
     * The full CName endpoint for this account.
     */
    @JsonProperty(value = "properties.endpoint", access = JsonProperty.Access.WRITE_ONLY)
    private String endpoint;

    /**
     * The default owner group for all new folders and files created in the
     * Data Lake Store account.
     */
    @JsonProperty(value = "properties.defaultGroup", access = JsonProperty.Access.WRITE_ONLY)
    private String defaultGroup;

    /**
     * The Key Vault encryption configuration.
     */
    @JsonProperty(value = "properties.encryptionConfig", access = JsonProperty.Access.WRITE_ONLY)
    private EncryptionConfig encryptionConfig;

    /**
     * The current state of encryption for this Data Lake Store account.
     * Possible values include: 'Enabled', 'Disabled'.
     */
    @JsonProperty(value = "properties.encryptionState", access = JsonProperty.Access.WRITE_ONLY)
    private EncryptionState encryptionState;

    /**
     * The current state of encryption provisioning for this Data Lake Store
     * account. Possible values include: 'Creating', 'Succeeded'.
     */
    @JsonProperty(value = "properties.encryptionProvisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private EncryptionProvisioningState encryptionProvisioningState;

    /**
     * The list of firewall rules associated with this Data Lake Store account.
     */
    @JsonProperty(value = "properties.firewallRules", access = JsonProperty.Access.WRITE_ONLY)
    private List<FirewallRuleInner> firewallRules;

    /**
     * The current state of the IP address firewall for this Data Lake Store
     * account. Possible values include: 'Enabled', 'Disabled'.
     */
    @JsonProperty(value = "properties.firewallState", access = JsonProperty.Access.WRITE_ONLY)
    private FirewallState firewallState;

    /**
     * The current state of allowing or disallowing IPs originating within
     * Azure through the firewall. If the firewall is disabled, this is not
     * enforced. Possible values include: 'Enabled', 'Disabled'.
     */
    @JsonProperty(value = "properties.firewallAllowAzureIps", access = JsonProperty.Access.WRITE_ONLY)
    private FirewallAllowAzureIpsState firewallAllowAzureIps;

    /**
     * The list of trusted identity providers associated with this Data Lake
     * Store account.
     */
    @JsonProperty(value = "properties.trustedIdProviders", access = JsonProperty.Access.WRITE_ONLY)
    private List<TrustedIdProviderInner> trustedIdProviders;

    /**
     * The current state of the trusted identity provider feature for this Data
     * Lake Store account. Possible values include: 'Enabled', 'Disabled'.
     */
    @JsonProperty(value = "properties.trustedIdProviderState", access = JsonProperty.Access.WRITE_ONLY)
    private TrustedIdProviderState trustedIdProviderState;

    /**
     * The commitment tier to use for next month. Possible values include:
     * 'Consumption', 'Commitment_1TB', 'Commitment_10TB', 'Commitment_100TB',
     * 'Commitment_500TB', 'Commitment_1PB', 'Commitment_5PB'.
     */
    @JsonProperty(value = "properties.newTier", access = JsonProperty.Access.WRITE_ONLY)
    private TierType newTier;

    /**
     * The commitment tier in use for the current month. Possible values
     * include: 'Consumption', 'Commitment_1TB', 'Commitment_10TB',
     * 'Commitment_100TB', 'Commitment_500TB', 'Commitment_1PB',
     * 'Commitment_5PB'.
     */
    @JsonProperty(value = "properties.currentTier", access = JsonProperty.Access.WRITE_ONLY)
    private TierType currentTier;


    /**
     * Container interface for all the definitions that need to be implemented.
     */
    interface Definition extends
            DefinitionStages.Blank,
            DefinitionStages.WithGroup,
            DefinitionStages.WithCreate {
    }

    /**
     * Grouping of all the Data Lake Store account definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of the Data Lake Store account definition.
         */
        interface Blank extends GroupableResource.DefinitionWithRegion<WithGroup> {
        }

        /**
         * The stage of a Data Lake Store account definition allowing to specify the resource group.
         */
        interface WithGroup extends GroupableResource.DefinitionStages.WithGroup<WithCreate> {
        }

        /**
         * A storage account definition with sufficient inputs to create a new
         * Data Lake Store account in the cloud, but exposing additional optional inputs to
         * specify.
         */
        interface WithCreate extends
                Creatable<DataLakeStoreAccount>,
                Resource.DefinitionWithTags<WithCreate> {
        }
    }

    /**
     * Container interface for all the settings that can be modified.
     */
    interface Update extends
            Appliable<DataLakeStoreAccount>,
            Resource.UpdateWithTags<Update> {
    }

    /**
     * Grouping of all the Data Lake Store account update stages.
     */
    interface UpdateStages {
    }
}

