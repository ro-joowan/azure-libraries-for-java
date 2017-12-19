/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.microsoft.azure.management.batchai.implementation;

import com.microsoft.azure.management.apigeneration.LangDefinition;
import com.microsoft.azure.management.batchai.Cluster;
import com.microsoft.azure.management.batchai.Clusters;
import com.microsoft.azure.management.resources.fluentcore.arm.collection.implementation.TopLevelModifiableResourcesImpl;

/**
 *  Implementation for Clusters.
 */
@LangDefinition
class ClustersImpl
        extends TopLevelModifiableResourcesImpl<
        Cluster,
        ClusterImpl,
        ClusterInner,
        ClustersInner,
        BatchAIManager>
        implements Clusters {

    ClustersImpl(final BatchAIManager batchAIManager) {
        super(batchAIManager.inner().clusters(), batchAIManager);
    }

    @Override
    public ClusterImpl define(String name) {
        return wrapModel(name);
    }

    // Fluent model create helpers

    @Override
    protected ClusterImpl wrapModel(String name) {
        ClusterInner inner = new ClusterInner();
        return new ClusterImpl(name, inner, super.manager());
    }

    @Override
    protected ClusterImpl wrapModel(ClusterInner inner) {
        if (inner == null) {
            return null;
        }
        return new ClusterImpl(inner.name(), inner, this.manager());
    }
}