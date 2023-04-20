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

object AuthApi {

  def apply(baseUrl: String = TestServer.serverBaseUrl) = new AuthApi(baseUrl)
}

class AuthApi(baseUrl: String) extends CirceSchema {

  /**
   * Generate new ApiKey of logged in User
   * 
   * Expected answers:
   *   code 200 : JsonValueString ()
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
  def generateNewApiKey(username: String, password: String, bearerToken: String, apiKey: String)() =
    basicRequest
      .method(Method.PATCH, uri"$baseUrl/auth/profile/apikey")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[JsonValueString])

  /**
   * Check a given Login for is authenticated
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
   */
  def isAuthenticated(username: String, password: String, bearerToken: String, apiKey: String)() =
    basicRequest
      .method(Method.GET, uri"$baseUrl/auth/authenticated")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[JsonValueBoolean])

  /**
   * Login for one user and return Login Information
   * 
   * Expected answers:
   *   code 200 : LoginResult ()
   *   code 400 : String (Invalid value for: body)
   *   code 0 : ErrorDescription ()
   *              Headers :
   *                x-error-code - Error Code
   *                x-error-message - Message of the MongoCampException
   *                x-error-additional-info - Additional information for the MongoCampException
   * 
   * @param login Login Information for your Users
   */
  def login(login: Login) =
    basicRequest
      .method(Method.POST, uri"$baseUrl/auth/login")
      .contentType("application/json")
      .body(login)
      .response(asJson[LoginResult])

  /**
   * Logout by bearer Token
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
   */
  def logout(username: String, password: String, bearerToken: String, apiKey: String)() =
    basicRequest
      .method(Method.POST, uri"$baseUrl/auth/logout")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[JsonValueBoolean])

  /**
   * Logout by bearer Token
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
   */
  def logoutByDelete(username: String, password: String, bearerToken: String, apiKey: String)() =
    basicRequest
      .method(Method.DELETE, uri"$baseUrl/auth/logout")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[JsonValueBoolean])

  /**
   * Refresh Token and return Login Information
   * 
   * Expected answers:
   *   code 200 : LoginResult ()
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
  def refreshToken(username: String, password: String, bearerToken: String, apiKey: String)() =
    basicRequest
      .method(Method.GET, uri"$baseUrl/auth/token/refresh")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[LoginResult])

  /**
   * Change Password of logged in User
   * 
   * Expected answers:
   *   code 200 : JsonValueBoolean ()
   *   code 400 : String (Invalid value for: body)
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
   * @param passwordUpdateRequest 
   */
  def updatePassword(username: String, password: String, bearerToken: String, apiKey: String)(passwordUpdateRequest: PasswordUpdateRequest) =
    basicRequest
      .method(Method.PATCH, uri"$baseUrl/auth/profile/password")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .body(passwordUpdateRequest)
      .response(asJson[JsonValueBoolean])

  /**
   * Return the User Profile of loggedin user
   * 
   * Expected answers:
   *   code 200 : UserProfile ()
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
  def userProfile(username: String, password: String, bearerToken: String, apiKey: String)() =
    basicRequest
      .method(Method.GET, uri"$baseUrl/auth/profile")
      .contentType("application/json")
      .auth.basic(username, password)
      .auth.bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[UserProfile])

}
