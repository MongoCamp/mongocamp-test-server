/**
 * mongocamp-server
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.4.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package dev.mongocamp.server.test.client.model

case class IndexOptionsRequest(
    name: Option[String] = None,
    background: Option[Boolean] = None,
    defaultLanguage: Option[String] = None,
    textVersion: Option[Int] = None,
    expireAfter: Option[String] = None,
    unique: Option[Boolean] = None,
    max: Option[Double] = None,
    min: Option[Double] = None
)
