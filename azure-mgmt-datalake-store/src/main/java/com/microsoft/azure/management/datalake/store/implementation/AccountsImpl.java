/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.datalake.store.implementation;

import com.microsoft.azure.PagedList;
import com.microsoft.azure.management.apigeneration.LangDefinition;
import com.microsoft.azure.management.datalake.store.Accounts;
import com.microsoft.azure.management.datalake.store.DataLakeStoreAccount;
import com.microsoft.azure.management.datalake.store.DataLakeStoreAccountBasic;
import com.microsoft.azure.management.resources.fluentcore.arm.collection.implementation.GroupableResourcesImpl;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import rx.Completable;
import rx.Observable;

/**
 * The implementation of Accounts and its parent interfaces.
 */
@LangDefinition
class AccountsImpl
        extends GroupableResourcesImpl<
        DataLakeStoreAccountBasic,
        DataLakeStoreAccountBasicImpl,
        DataLakeStoreAccountBasicInner,
        AccountsInner,
        DataLakeStoreManager>
        implements Accounts {

    AccountsImpl(final DataLakeStoreManager dataLakeStoreManager) {
        super(dataLakeStoreManager.inner().accounts(), dataLakeStoreManager);
    }

    @Override
    public ServiceFuture<DataLakeStoreAccount> getByIdAsync(String id, ServiceCallback<DataLakeStoreAccount> callback) {
        return null;
    }

    @Override
    public ServiceFuture<DataLakeStoreAccount> getByResourceGroupAsync(String resourceGroupName, String name, ServiceCallback<DataLakeStoreAccount> callback) {
        return null;
    }

    @Override
    public PagedList<DataLakeStoreAccountBasic> listByResourceGroup(String resourceGroupName) {
        return null;
    }

    @Override
    public Observable<DataLakeStoreAccount> listByResourceGroupAsync(String resourceGroupName) {
        return null;
    }

    @Override
    protected Observable<DataLakeStoreAccountBasicInner> getInnerAsync(String resourceGroupName, String name) {
        return null;
    }

    @Override
    protected Completable deleteInnerAsync(String resourceGroupName, String name) {
        return null;
    }

    @Override
    protected DataLakeStoreAccountBasicImpl wrapModel(String name) {
        return null;
    }

    @Override
    protected DataLakeStoreAccountBasicImpl wrapModel(DataLakeStoreAccountBasicInner inner) {
        return null;
    }

    @Override
    public DataLakeStoreAccount.DefinitionStages.Blank define(String name) {
        return null;
    }

    @Override
    public PagedList<DataLakeStoreAccountBasic> list() {
        return null;
    }

    @Override
    public Observable<DataLakeStoreAccountBasic> listAsync() {
        return null;
    }
}

