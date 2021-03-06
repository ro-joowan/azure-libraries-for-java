/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement.implementation;

import java.util.List;
import com.microsoft.azure.management.apimanagement.ParameterContract;
import com.microsoft.azure.management.apimanagement.RequestContract;
import com.microsoft.azure.management.apimanagement.ResponseContract;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.Resource;

/**
 * Api Operation details.
 */
@JsonFlatten
public class OperationContractInner extends Resource {
    /**
     * Collection of URL template parameters.
     */
    @JsonProperty(value = "properties.templateParameters")
    private List<ParameterContract> templateParameters;

    /**
     * Description of the operation. May include HTML formatting tags.
     */
    @JsonProperty(value = "properties.description")
    private String description;

    /**
     * An entity containing request details.
     */
    @JsonProperty(value = "properties.request")
    private RequestContract request;

    /**
     * Array of Operation responses.
     */
    @JsonProperty(value = "properties.responses")
    private List<ResponseContract> responses;

    /**
     * Operation Policies.
     */
    @JsonProperty(value = "properties.policies")
    private String policies;

    /**
     * Operation Name.
     */
    @JsonProperty(value = "properties.displayName", required = true)
    private String displayName;

    /**
     * A Valid HTTP Operation Method. Typical Http Methods like GET, PUT, POST
     * but not limited by only them.
     */
    @JsonProperty(value = "properties.method", required = true)
    private String method;

    /**
     * Relative URL template identifying the target resource for this
     * operation. May include parameters. Example:
     * /customers/{cid}/orders/{oid}/?date={date}.
     */
    @JsonProperty(value = "properties.urlTemplate", required = true)
    private String urlTemplate;

    /**
     * Get the templateParameters value.
     *
     * @return the templateParameters value
     */
    public List<ParameterContract> templateParameters() {
        return this.templateParameters;
    }

    /**
     * Set the templateParameters value.
     *
     * @param templateParameters the templateParameters value to set
     * @return the OperationContractInner object itself.
     */
    public OperationContractInner withTemplateParameters(List<ParameterContract> templateParameters) {
        this.templateParameters = templateParameters;
        return this;
    }

    /**
     * Get the description value.
     *
     * @return the description value
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description value.
     *
     * @param description the description value to set
     * @return the OperationContractInner object itself.
     */
    public OperationContractInner withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the request value.
     *
     * @return the request value
     */
    public RequestContract request() {
        return this.request;
    }

    /**
     * Set the request value.
     *
     * @param request the request value to set
     * @return the OperationContractInner object itself.
     */
    public OperationContractInner withRequest(RequestContract request) {
        this.request = request;
        return this;
    }

    /**
     * Get the responses value.
     *
     * @return the responses value
     */
    public List<ResponseContract> responses() {
        return this.responses;
    }

    /**
     * Set the responses value.
     *
     * @param responses the responses value to set
     * @return the OperationContractInner object itself.
     */
    public OperationContractInner withResponses(List<ResponseContract> responses) {
        this.responses = responses;
        return this;
    }

    /**
     * Get the policies value.
     *
     * @return the policies value
     */
    public String policies() {
        return this.policies;
    }

    /**
     * Set the policies value.
     *
     * @param policies the policies value to set
     * @return the OperationContractInner object itself.
     */
    public OperationContractInner withPolicies(String policies) {
        this.policies = policies;
        return this;
    }

    /**
     * Get the displayName value.
     *
     * @return the displayName value
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName value.
     *
     * @param displayName the displayName value to set
     * @return the OperationContractInner object itself.
     */
    public OperationContractInner withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the method value.
     *
     * @return the method value
     */
    public String method() {
        return this.method;
    }

    /**
     * Set the method value.
     *
     * @param method the method value to set
     * @return the OperationContractInner object itself.
     */
    public OperationContractInner withMethod(String method) {
        this.method = method;
        return this;
    }

    /**
     * Get the urlTemplate value.
     *
     * @return the urlTemplate value
     */
    public String urlTemplate() {
        return this.urlTemplate;
    }

    /**
     * Set the urlTemplate value.
     *
     * @param urlTemplate the urlTemplate value to set
     * @return the OperationContractInner object itself.
     */
    public OperationContractInner withUrlTemplate(String urlTemplate) {
        this.urlTemplate = urlTemplate;
        return this;
    }

}
