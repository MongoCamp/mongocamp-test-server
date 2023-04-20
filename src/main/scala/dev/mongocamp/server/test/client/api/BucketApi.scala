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
package dev.mongocamp.server.test.client.api

import dev.mongocamp.server.test.TestServer
import dev.mongocamp.server.test.client.core.JsonSupport._
import dev.mongocamp.server.test.client.model._
import sttp.client3._
import sttp.model.Method

object BucketApi {

  def apply(baseUrl: String = TestServer.serverBaseUrl) = new BucketApi(baseUrl)
}

class BucketApi(baseUrl: String) extends CirceSchema {

  /**
   * Delete all Files in Bucket
   * 
   * Expected answers:
   *   code 200 : JsonValueBoolean ()
   *   code 0 : ErrorDescription ()
   *              Headers :
   *                x-error-code - Error Code
   *                x-error-message - Message of the MongoCampException
   *                x-error-additional-info - Additional information for the MongoCampException
   * 
   * Available security schemes:
   *   httpAuth1 (http)
   *   httpAuth (http)
   *   apiKeyAuth (apiKey)
   * 
   * @param bucketName The name of your MongoDb Collection
   */
  def clearBucket(username: String, password: String, bearerToken: String, apiKey: String)(bucketName: String) =
    basicRequest
      .method(Method.DELETE, uri"$baseUrl/mongodb/buckets/${bucketName}/clear")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[JsonValueBoolean])

  /**
   * Delete a given Bucket
   * 
   * Expected answers:
   *   code 200 : JsonValueBoolean ()
   *   code 0 : ErrorDescription ()
   *              Headers :
   *                x-error-code - Error Code
   *                x-error-message - Message of the MongoCampException
   *                x-error-additional-info - Additional information for the MongoCampException
   * 
   * Available security schemes:
   *   httpAuth1 (http)
   *   httpAuth (http)
   *   apiKeyAuth (apiKey)
   * 
   * @param bucketName The name of your MongoDb Collection
   */
  def deleteBucket(username: String, password: String, bearerToken: String, apiKey: String)(bucketName: String) =
    basicRequest
      .method(Method.DELETE, uri"$baseUrl/mongodb/buckets/${bucketName}")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[JsonValueBoolean])

  /**
   * All Information about a single Bucket
   * 
   * Expected answers:
   *   code 200 : BucketInformation ()
   *   code 0 : ErrorDescription ()
   *              Headers :
   *                x-error-code - Error Code
   *                x-error-message - Message of the MongoCampException
   *                x-error-additional-info - Additional information for the MongoCampException
   * 
   * Available security schemes:
   *   httpAuth1 (http)
   *   httpAuth (http)
   *   apiKeyAuth (apiKey)
   * 
   * @param bucketName The name of your MongoDb Collection
   */
  def getBucket(username: String, password: String, bearerToken: String, apiKey: String)(bucketName: String) =
    basicRequest
      .method(Method.GET, uri"$baseUrl/mongodb/buckets/${bucketName}")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[BucketInformation])

  /**
   * List of all Buckets of the default database
   * 
   * Expected answers:
   *   code 200 : Seq[String] ()
   *   code 0 : ErrorDescription ()
   *              Headers :
   *                x-error-code - Error Code
   *                x-error-message - Message of the MongoCampException
   *                x-error-additional-info - Additional information for the MongoCampException
   * 
   * Available security schemes:
   *   httpAuth1 (http)
   *   httpAuth (http)
   *   apiKeyAuth (apiKey)
   */
  def listBuckets(username: String, password: String, bearerToken: String, apiKey: String)() =
    basicRequest
      .method(Method.GET, uri"$baseUrl/mongodb/buckets")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[Seq[String]])

}
