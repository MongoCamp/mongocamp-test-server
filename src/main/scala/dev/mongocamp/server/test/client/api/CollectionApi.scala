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

import dev.mongocamp.server.converter.CirceSchema
import dev.mongocamp.server.test.TestServer
import dev.mongocamp.server.test.client.core.JsonSupport._
import dev.mongocamp.server.test.client.model._
import sttp.client3._
import sttp.model.Method

object CollectionApi {

  def apply(baseUrl: String = TestServer.serverBaseUrl) = new CollectionApi(baseUrl)
}

class CollectionApi(baseUrl: String) extends CirceSchema {

  /**
   * Aggregate in a given Collection
   * 
   * Expected answers:
   *   code 200 : Seq[Map[String, String]] ()
   *              Headers :
   *                x-pagination-count-rows - count all elements
   *                x-pagination-rows-per-page - Count elements per page
   *                x-pagination-current-page - Current page
   *                x-pagination-count-pages - Count pages
   *   code 400 : String (Invalid value for: body, Invalid value for: query parameter rowsPerPage, Invalid value for: query parameter page)
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
   * @param collectionName The name of your MongoDb Collection
   * @param mongoAggregateRequest 
   * @param rowsPerPage Count elements per page
   * @param page Requested page of the ResultSets
   */
  def aggregate(username: String, password: String, bearerToken: String, apiKey: String)(collectionName: String, mongoAggregateRequest: MongoAggregateRequest, rowsPerPage: Option[Long] = None, page: Option[Long] = None) =
    {
      val requestBodyString = encodeAnyToJson(mongoAggregateRequest).toString() // todo: Validate on code generation
      basicRequest
        .method(Method.POST, uri"$baseUrl/mongodb/collections/${collectionName}/aggregate?rowsPerPage=${ rowsPerPage }&page=${ page }")
        .contentType("application/json")
        .auth.basic(username, password)
        .auth.bearer(bearerToken)
        .header("X-AUTH-APIKEY", apiKey)
        .body(requestBodyString)
        .response(asJson[Seq[Map[String, Any]]])
    }

  /**
   * Delete all Document in Collection
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
   * @param collectionName The name of your MongoDb Collection
   */
  def clearCollection(username: String, password: String, bearerToken: String, apiKey: String)(collectionName: String) =
    basicRequest
      .method(Method.DELETE, uri"$baseUrl/mongodb/collections/${collectionName}/clear")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[JsonValueBoolean])

  /**
   * Delete a given Collection
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
   * @param collectionName The name of your MongoDb Collection
   */
  def deleteCollection(username: String, password: String, bearerToken: String, apiKey: String)(collectionName: String) =
    basicRequest
      .method(Method.DELETE, uri"$baseUrl/mongodb/collections/${collectionName}")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[JsonValueBoolean])

  /**
   * Distinct for Field in a given Collection
   * 
   * Expected answers:
   *   code 200 : Seq[String] ()
   *              Headers :
   *                x-pagination-count-rows - count all elements
   *                x-pagination-rows-per-page - Count elements per page
   *                x-pagination-current-page - Current page
   *                x-pagination-count-pages - Count pages
   *   code 400 : String (Invalid value for: query parameter rowsPerPage, Invalid value for: query parameter page)
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
   * @param collectionName The name of your MongoDb Collection
   * @param field The field for your distinct Request.
   * @param rowsPerPage Count elements per page
   * @param page Requested page of the ResultSets
   */
  def distinct(username: String, password: String, bearerToken: String, apiKey: String)(collectionName: String, field: String, rowsPerPage: Option[Long] = None, page: Option[Long] = None) =
    basicRequest
      .method(Method.POST, uri"$baseUrl/mongodb/collections/${collectionName}/distinct/${field}?rowsPerPage=${ rowsPerPage }&page=${ page }")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[Seq[Any]])

  /**
   * List the Fields in a given collection
   * 
   * Expected answers:
   *   code 200 : Seq[String] ()
   *   code 400 : String (Invalid value for: query parameter sample size)
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
   * @param collectionName The name of your MongoDb Collection
   * @param sampleSize Use sample size greater 0 (e.g. 1000) for better performance on big collections
   */
  def getCollectionFields(username: String, password: String, bearerToken: String, apiKey: String)(collectionName: String, sampleSize: Option[Int] = None) =
    basicRequest
      .method(Method.GET, uri"$baseUrl/mongodb/collections/${collectionName}/fields?sample size=${ sampleSize }")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[Seq[String]])

  /**
   * All Information about a single Collection
   * 
   * Expected answers:
   *   code 200 : CollectionStatus ()
   *   code 400 : String (Invalid value for: query parameter includeDetails)
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
   * @param collectionName The name of your MongoDb Collection
   * @param includeDetails Include all details for the Collection
   */
  def getCollectionInformation(username: String, password: String, bearerToken: String, apiKey: String)(collectionName: String, includeDetails: Option[Boolean] = None) =
    basicRequest
      .method(Method.GET, uri"$baseUrl/mongodb/collections/${collectionName}?includeDetails=${ includeDetails }")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[CollectionStatus])

  /**
   * List the Fields in a given collection
   * 
   * Expected answers:
   *   code 200 : JsonSchema ()
   *   code 400 : String (Invalid value for: query parameter sampleSize, Invalid value for: query parameter deepth)
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
   * @param collectionName The name of your MongoDb Collection
   * @param sampleSize Use sample size greater 0 (e.g. 5000) for better performance on big collections
   * @param deepth How deep should the objects extracted
   */
  def getJsonSchema(username: String, password: String, bearerToken: String, apiKey: String)(collectionName: String, sampleSize: Option[Int] = None, deepth: Option[Int] = None) =
    basicRequest
      .method(Method.GET, uri"$baseUrl/mongodb/collections/${collectionName}/schema?sampleSize=${ sampleSize }&deepth=${ deepth }")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[JsonSchema])

  /**
   * List the Fields in a given collection
   * 
   * Expected answers:
   *   code 200 : SchemaAnalysis ()
   *   code 400 : String (Invalid value for: query parameter sampleSize, Invalid value for: query parameter deepth)
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
   * @param collectionName The name of your MongoDb Collection
   * @param sampleSize Use sample size greater 0 (e.g. 5000) for better performance on big collections
   * @param deepth How deep should the objects extracted
   */
  def getSchemaAnalysis(username: String, password: String, bearerToken: String, apiKey: String)(collectionName: String, sampleSize: Option[Int] = None, deepth: Option[Int] = None) =
    basicRequest
      .method(Method.GET, uri"$baseUrl/mongodb/collections/${collectionName}/schema/analysis?sampleSize=${ sampleSize }&deepth=${ deepth }")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[SchemaAnalysis])

  /**
   * List of all Collections of the default database
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
  def listCollections(username: String, password: String, bearerToken: String, apiKey: String)() =
    basicRequest
      .method(Method.GET, uri"$baseUrl/mongodb/collections")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[Seq[String]])

  /**
   * List of all Collections of the given database
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
   * 
   * @param databaseName Name of your Database
   */
  def listCollectionsByDatabase(username: String, password: String, bearerToken: String, apiKey: String)(databaseName: String) =
    basicRequest
      .method(Method.GET, uri"$baseUrl/mongodb/databases/${databaseName}/collections")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[Seq[String]])

}