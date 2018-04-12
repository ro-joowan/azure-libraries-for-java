/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.datalake.store.implementation;

import com.microsoft.azure.management.apigeneration.LangDefinition;
import com.microsoft.azure.management.datalake.store.DataLakeStoreAccount;
import com.microsoft.azure.management.resources.fluentcore.arm.models.implementation.GroupableResourceImpl;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Implementation for {@link DataLakeStoreAccount}.
 */
@LangDefinition
class DataLakeStoreAccountImpl
        extends GroupableResourceImpl<
        DataLakeStoreAccount,
        DataLakeStoreAccountInner,
        DataLakeStoreAccountImpl,
        DataLakeStoreManager>
        implements
        DataLakeStoreAccount,
        DataLakeStoreAccount.Definition,
        DataLakeStoreAccount.Update {

    private CreateDataLakeStoreAccountParametersInner createParameters;
    private UpdateDataLakeStoreAccountParametersInner updateParameters;

    DataLakeStoreAccountImpl(
            String name,
            DataLakeStoreAccountInner innerModel,
            final DataLakeStoreManager dataLakeStoreManager) {
        super(name, innerModel, dataLakeStoreManager);
        this.createParameters = new CreateDataLakeStoreAccountParametersInner();
    }

    @Override
    public Observable<DataLakeStoreAccount> refreshAsync() {
        return super.refreshAsync().map(new Func1<DataLakeStoreAccount, DataLakeStoreAccount>() {
            @Override
            public DataLakeStoreAccount call(DataLakeStoreAccount dataLakeStoreAccount) {
                DataLakeStoreAccountImpl impl = (DataLakeStoreAccountImpl) dataLakeStoreAccount;
                impl.clearWrapperProperties();
                return impl;
            }
        });
    }

    @Override
    protected Observable<DataLakeStoreAccountInner> getInnerAsync() {
        return this.manager().inner().accounts().getByResourceGroupAsync(this.resourceGroupName(), this.name());
    }

    @Override
    public Observable<DataLakeStoreAccount> createResourceAsync() {
        createParameters.withLocation(this.regionName());
        createParameters.withTags(this.inner().getTags());
        final AccountsInner client = this.manager().inner().accounts();
        return this.manager().inner().accounts().createAsync(
                this.resourceGroupName(), this.name(), createParameters)
                .flatMap(new Func1<DataLakeStoreAccountInner, Observable<DataLakeStoreAccountInner>>() {
                    @Override
                    public Observable<DataLakeStoreAccountInner> call(DataLakeStoreAccountInner dataLakeStoreAccountInner) {
                        return client.getByResourceGroupAsync(resourceGroupName(), name());
                    }
                })
                .map(innerToFluentMap(this))
                .doOnNext(new Action1<DataLakeStoreAccount>() {
                    @Override
                    public void call(DataLakeStoreAccount dataLakeStoreAccount) {
                        clearWrapperProperties();
                    }
                });
    }

    @Override
    public DataLakeStoreAccountImpl update() {
        createParameters = null;
        updateParameters = new UpdateDataLakeStoreAccountParametersInner();
        return super.update();
    }

    @Override
    public Observable<DataLakeStoreAccount> updateResourceAsync() {
        updateParameters.withTags(this.inner().getTags());
        return this.manager().inner().accounts().updateAsync(
                resourceGroupName(), name(), updateParameters)
                .map(innerToFluentMap(this))
                .doOnNext(new Action1<DataLakeStoreAccount>() {
                    @Override
                    public void call(DataLakeStoreAccount dataLakeStoreAccount) {
                        clearWrapperProperties();
                    }
                });
    }

    private void clearWrapperProperties() {
    }
}
