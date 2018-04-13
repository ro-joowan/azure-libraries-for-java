/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.datalake.store.implementation;

import com.microsoft.azure.PagedList;
import com.microsoft.azure.management.apigeneration.LangDefinition;
import com.microsoft.azure.management.datalake.store.DataLakeStoreAccount;
import com.microsoft.azure.management.datalake.store.DataLakeStoreAccounts;
import com.microsoft.azure.management.resources.fluentcore.arm.collection.implementation.GroupableResourcesImpl;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import rx.Completable;
import rx.Observable;

/**
 * The implementation of DataLakeStoreAccounts and its parent interfaces.
 */
@LangDefinition
class DataLakeStoreAccountsImpl
        extends GroupableResourcesImpl<
        DataLakeStoreAccount,
        DataLakeStoreAccountImpl,
        DataLakeStoreAccountInner,
        AccountsInner,
        DataLakeStoreManager>
        implements DataLakeStoreAccounts {

    DataLakeStoreAccountsImpl(final DataLakeStoreManager dataLakeStoreManager) {
        super(dataLakeStoreManager.inner().accounts(), dataLakeStoreManager);
    }

//    @Override
//    public ServiceFuture<DataLakeStoreAccount> getByIdAsync(String id, ServiceCallback<DataLakeStoreAccount> callback) {
//        return null;
//    }
//
//    @Override
//    public ServiceFuture<DataLakeStoreAccount> getByResourceGroupAsync(String resourceGroupName, String name, ServiceCallback<DataLakeStoreAccount> callback) {
//        return null;
//    }

    @Override
    public PagedList<DataLakeStoreAccount> listByResourceGroup(String resourceGroupName) {
        return null;
    }

    @Override
    public Observable<DataLakeStoreAccount> listByResourceGroupAsync(String resourceGroupName) {
        return null;
    }

    @Override
    protected Observable<DataLakeStoreAccountInner> getInnerAsync(String resourceGroupName, String name) {
        return null;
    }

    @Override
    protected Completable deleteInnerAsync(String resourceGroupName, String name) {
        return null;
    }

    @Override
    protected DataLakeStoreAccountImpl wrapModel(String name) {
        return new DataLakeStoreAccountImpl(name, new DataLakeStoreAccountInner(), this.manager());
    }

    @Override
    public DataLakeStoreAccount.DefinitionStages.Blank define(String name) {
        return wrapModel(name);
    }


    @Override
    protected DataLakeStoreAccountImpl wrapModel(DataLakeStoreAccountInner inner) {
        return null;
    }


    @Override
    public PagedList<DataLakeStoreAccount> list() {
        return null;
    }

    @Override
    public Observable<DataLakeStoreAccount> listAsync() {
        return null;
    }

    @Override
    public NameAvailabilityInformationInner checkNameAvailability(String location, String name) {

        return this.inner().checkNameAvailability(location, name);
    }


    @Override
    public Observable<NameAvailabilityInformationInner> checkNameAvailabilityAsync(String location, String name) {

        return this.inner().checkNameAvailabilityAsync(location, name);
    }
}

