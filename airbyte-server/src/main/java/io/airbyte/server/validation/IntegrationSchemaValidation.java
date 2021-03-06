/*
 * MIT License
 *
 * Copyright (c) 2020 Airbyte
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.airbyte.server.validation;

import com.fasterxml.jackson.databind.JsonNode;
import io.airbyte.commons.json.JsonSchemaValidator;
import io.airbyte.commons.json.JsonValidationException;
import io.airbyte.config.DestinationConnectionSpecification;
import io.airbyte.config.SourceConnectionSpecification;

public class IntegrationSchemaValidation {

  private final JsonSchemaValidator jsonSchemaValidator;

  public IntegrationSchemaValidation() {
    this.jsonSchemaValidator = new JsonSchemaValidator();
  }

  public void validateConfig(final SourceConnectionSpecification sourceConnectionSpecification,
                             final JsonNode configJson)
      throws JsonValidationException {
    final JsonNode schemaJson = sourceConnectionSpecification.getSpecification();

    jsonSchemaValidator.ensure(schemaJson, configJson);
  }

  public void validateConfig(final DestinationConnectionSpecification destinationConnectionSpecification,
                             final JsonNode configJson)
      throws JsonValidationException {
    final JsonNode schemaJson = destinationConnectionSpecification.getSpecification();

    jsonSchemaValidator.ensure(schemaJson, configJson);
  }

}
