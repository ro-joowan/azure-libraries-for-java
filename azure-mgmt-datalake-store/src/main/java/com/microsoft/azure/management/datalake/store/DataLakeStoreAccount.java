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

