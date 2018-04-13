/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.datalake.store;

import com.microsoft.azure.management.apigeneration.Fluent;
import com.microsoft.azure.management.apigeneration.Method;
import com.microsoft.azure.management.datalake.store.implementation.AccountsInner;
import com.microsoft.azure.management.datalake.store.implementation.DataLakeStoreManager;
import com.microsoft.azure.management.datalake.store.implementation.NameAvailabilityInformationInner;
import com.microsoft.azure.management.resources.fluentcore.arm.collection.SupportsDeletingByResourceGroup;
import com.microsoft.azure.management.resources.fluentcore.arm.collection.SupportsGettingById;
import com.microsoft.azure.management.resources.fluentcore.arm.collection.SupportsGettingByResourceGroup;
import com.microsoft.azure.management.resources.fluentcore.arm.collection.SupportsListingByResourceGroup;
import com.microsoft.azure.management.resources.fluentcore.arm.models.HasManager;
import com.microsoft.azure.management.resources.fluentcore.collection.SupportsCreating;
import com.microsoft.azure.management.resources.fluentcore.collection.SupportsDeletingById;
import com.microsoft.azure.management.resources.fluentcore.collection.SupportsListing;
import com.microsoft.azure.management.resources.fluentcore.model.HasInner;
import rx.Observable;

/**
 * Entry point for Data Lake Store accounts management API.
 */
@Fluent
public interface DataLakeStoreAccounts extends
        SupportsListing<DataLakeStoreAccount>,
        SupportsCreating<DataLakeStoreAccount.DefinitionStages.Blank>,
        SupportsDeletingById,
        SupportsListingByResourceGroup<DataLakeStoreAccount>,
        SupportsGettingByResourceGroup<DataLakeStoreAccount>,
        SupportsGettingById<DataLakeStoreAccount>,
        SupportsDeletingByResourceGroup,
        HasManager<DataLakeStoreManager>,
        HasInner<AccountsInner> {

    @Method
    NameAvailabilityInformationInner checkNameAvailability(String locaiton, String name);

    @Method
    Observable<NameAvailabilityInformationInner> checkNameAvailabilityAsync(String locaiton, String name);
}
