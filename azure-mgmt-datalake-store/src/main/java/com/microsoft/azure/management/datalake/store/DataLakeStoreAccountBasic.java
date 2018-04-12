/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.datalake.store;

import com.microsoft.azure.management.apigeneration.Fluent;
import com.microsoft.azure.management.datalake.store.implementation.DataLakeStoreAccountBasicInner;
import com.microsoft.azure.management.datalake.store.implementation.DataLakeStoreManager;
import com.microsoft.azure.management.resources.fluentcore.arm.models.GroupableResource;

/**
 * An immutable client-side representation of an Azure Data Lake Store account.
 */
@Fluent
public interface DataLakeStoreAccountBasic extends
        GroupableResource<DataLakeStoreManager, DataLakeStoreAccountBasicInner> {
}

