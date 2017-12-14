/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.management.appservice.ProxyOnlyResource;

/**
 * Class representing certificate renew request.
 */
@JsonFlatten
public class RenewCertificateOrderRequestInner extends ProxyOnlyResource {
    /**
     * Certificate Key Size.
     */
    @JsonProperty(value = "properties.keySize")
    private Integer keySize;

    /**
     * Csr to be used for re-key operation.
     */
    @JsonProperty(value = "properties.csr")
    private String csr;

    /**
     * Should we change the ASC type (from managed private key to external
     * private key and vice versa).
     */
    @JsonProperty(value = "properties.isPrivateKeyExternal")
    private Boolean isPrivateKeyExternal;

    /**
     * Get the keySize value.
     *
     * @return the keySize value
     */
    public Integer keySize() {
        return this.keySize;
    }

    /**
     * Set the keySize value.
     *
     * @param keySize the keySize value to set
     * @return the RenewCertificateOrderRequestInner object itself.
     */
    public RenewCertificateOrderRequestInner withKeySize(Integer keySize) {
        this.keySize = keySize;
        return this;
    }

    /**
     * Get the csr value.
     *
     * @return the csr value
     */
    public String csr() {
        return this.csr;
    }

    /**
     * Set the csr value.
     *
     * @param csr the csr value to set
     * @return the RenewCertificateOrderRequestInner object itself.
     */
    public RenewCertificateOrderRequestInner withCsr(String csr) {
        this.csr = csr;
        return this;
    }

    /**
     * Get the isPrivateKeyExternal value.
     *
     * @return the isPrivateKeyExternal value
     */
    public Boolean isPrivateKeyExternal() {
        return this.isPrivateKeyExternal;
    }

    /**
     * Set the isPrivateKeyExternal value.
     *
     * @param isPrivateKeyExternal the isPrivateKeyExternal value to set
     * @return the RenewCertificateOrderRequestInner object itself.
     */
    public RenewCertificateOrderRequestInner withIsPrivateKeyExternal(Boolean isPrivateKeyExternal) {
        this.isPrivateKeyExternal = isPrivateKeyExternal;
        return this;
    }

}
