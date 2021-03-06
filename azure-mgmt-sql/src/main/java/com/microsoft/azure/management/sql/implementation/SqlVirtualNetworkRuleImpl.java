/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.microsoft.azure.management.sql.implementation;

import com.microsoft.azure.management.apigeneration.LangDefinition;
import com.microsoft.azure.management.resources.fluentcore.arm.ResourceId;
import com.microsoft.azure.management.resources.fluentcore.arm.ResourceUtils;
import com.microsoft.azure.management.resources.fluentcore.arm.models.implementation.ExternalChildResourceImpl;
import com.microsoft.azure.management.sql.SqlVirtualNetworkRule;
import com.microsoft.azure.management.sql.SqlVirtualNetworkRuleOperations;
import com.microsoft.azure.management.sql.SqlServer;
import rx.Completable;
import rx.Observable;
import rx.functions.Func1;

import java.util.Objects;

/**
 * Implementation for SQL Virtual Network Rule interface.
 */
@LangDefinition
public class SqlVirtualNetworkRuleImpl
    extends
        ExternalChildResourceImpl<SqlVirtualNetworkRule, VirtualNetworkRuleInner, SqlServerImpl, SqlServer>
    implements
        SqlVirtualNetworkRule,
        SqlVirtualNetworkRule.SqlVirtualNetworkRuleDefinition<SqlServer.DefinitionStages.WithCreate>,
        SqlVirtualNetworkRule.Update,
        SqlVirtualNetworkRuleOperations.SqlVirtualNetworkRuleOperationsDefinition {

    private SqlServerManager sqlServerManager;
    private String resourceGroupName;
    private String sqlServerName;

    /**
     * Creates an instance of external child resource in-memory.
     *
     * @param name        the name of this external child resource
     * @param parent      reference to the parent of this external child resource
     * @param innerObject reference to the inner object representing this external child resource
     * @param sqlServerManager reference to the SQL server manager that accesses virtual network rule operations
     */
    SqlVirtualNetworkRuleImpl(String name, SqlServerImpl parent, VirtualNetworkRuleInner innerObject, SqlServerManager sqlServerManager) {
        super(name, parent, innerObject);

        Objects.requireNonNull(parent);
        Objects.requireNonNull(sqlServerManager);
        this.sqlServerManager = sqlServerManager;
        this.resourceGroupName = parent.resourceGroupName();
        this.sqlServerName = parent.name();
    }

    /**
     * Creates an instance of external child resource in-memory.
     *
     * @param resourceGroupName the resource group name
     * @param sqlServerName the parent SQL server name
     * @param name        the name of this external child resource
     * @param innerObject reference to the inner object representing this external child resource
     * @param sqlServerManager reference to the SQL server manager that accesses virtual network rule operations
     */
    SqlVirtualNetworkRuleImpl(String resourceGroupName, String sqlServerName, String name, VirtualNetworkRuleInner innerObject, SqlServerManager sqlServerManager) {
        super(name, null, innerObject);
        Objects.requireNonNull(sqlServerManager);
        this.sqlServerManager = sqlServerManager;
        this.resourceGroupName = resourceGroupName;
        this.sqlServerName = sqlServerName;
    }

    /**
     * Creates an instance of external child resource in-memory.
     *
     * @param name        the name of this external child resource
     * @param innerObject reference to the inner object representing this external child resource
     * @param sqlServerManager reference to the SQL server manager that accesses virtual network rule operations
     */
    SqlVirtualNetworkRuleImpl(String name, VirtualNetworkRuleInner innerObject, SqlServerManager sqlServerManager) {
        super(name, null, innerObject);
        Objects.requireNonNull(sqlServerManager);
        this.sqlServerManager = sqlServerManager;
    }

    @Override
    public Observable<SqlVirtualNetworkRule> createResourceAsync() {
        final SqlVirtualNetworkRuleImpl self = this;
        return this.sqlServerManager.inner().virtualNetworkRules()
            .createOrUpdateAsync(this.resourceGroupName, this.sqlServerName, this.name(), this.inner())
            .map(new Func1<VirtualNetworkRuleInner, SqlVirtualNetworkRule>() {
                @Override
                public SqlVirtualNetworkRule call(VirtualNetworkRuleInner inner) {
                    self.setInner(inner);
                    return self;
                }
            });
    }

    @Override
    public Observable<SqlVirtualNetworkRule> updateResourceAsync() {
        return this.createResourceAsync();
    }

    @Override
    public Observable<Void> deleteResourceAsync() {
        return this.sqlServerManager.inner().virtualNetworkRules().deleteAsync(this.resourceGroupName, this.sqlServerName, this.name());
    }

    @Override
    protected Observable<VirtualNetworkRuleInner> getInnerAsync() {
        return this.sqlServerManager.inner().virtualNetworkRules().getAsync(this.resourceGroupName, this.sqlServerName, this.name());
    }

    @Override
    public SqlVirtualNetworkRuleImpl update() {
        super.prepareUpdate();

        return this;
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String resourceGroupName() {
        return this.resourceGroupName;
    }

    @Override
    public String sqlServerName() {
        return this.sqlServerName;
    }

    @Override
    public String subnetId() {
        return this.inner().virtualNetworkSubnetId();
    }

    @Override
    public String state() {
        return this.inner().state().toString();
    }

    @Override
    public String parentId() {
        return ResourceUtils.parentResourceIdFromResourceId(this.id());
    }

    @Override
    public void delete() {
        this.deleteResourceAsync().toBlocking().last();
    }

    @Override
    public Completable deleteAsync() {
        return this.deleteResourceAsync().toCompletable();
    }

    @Override
    public SqlVirtualNetworkRuleImpl withExistingSqlServer(String resourceGroupName, String sqlServerName) {
        this.resourceGroupName = resourceGroupName;
        this.sqlServerName = sqlServerName;
        return this;
    }

    @Override
    public SqlVirtualNetworkRuleImpl withExistingSqlServerId(String sqlServerId) {
        Objects.requireNonNull(sqlServerId);
        ResourceId resourceId = ResourceId.fromString(sqlServerId);
        this.resourceGroupName = resourceId.resourceGroupName();
        this.sqlServerName = resourceId.name();
        return this;
    }

    @Override
    public SqlVirtualNetworkRuleImpl withExistingSqlServer(SqlServer sqlServer) {
        this.resourceGroupName = sqlServer.resourceGroupName();
        this.sqlServerName = sqlServer.name();
        return this;
    }

    @Override
    public SqlVirtualNetworkRuleImpl withSubnet(String networkId, String subnetName) {
        this.inner().withVirtualNetworkSubnetId(networkId + "/subnets/" + subnetName);
        this.inner().withIgnoreMissingVnetServiceEndpoint(false);
        return this;
    }

    @Override
    public SqlVirtualNetworkRuleImpl ignoreMissingSqlServiceEndpoint() {
        this.inner().withIgnoreMissingVnetServiceEndpoint(true);
        return this;
    }

    @Override
    public SqlServer.DefinitionStages.WithCreate attach() {
        return parent();
    }
}
