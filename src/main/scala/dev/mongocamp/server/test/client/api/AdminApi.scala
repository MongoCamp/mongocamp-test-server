/** mongocamp-server No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
  *
  * The version of the OpenAPI document: 1.4.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech). https://openapi-generator.tech Do not edit the class manually.
  */
package dev.mongocamp.server.test.client.api

import dev.mongocamp.server.converter.CirceSchema
import dev.mongocamp.server.test.TestServer
import dev.mongocamp.server.test.client.core.JsonSupport._
import dev.mongocamp.server.test.client.model._
import sttp.client3._
import sttp.model.Method

object AdminApi extends CirceSchema {
  def apply(baseUrl: String = TestServer.serverBaseUrl) = new AdminApi(baseUrl)
}

class AdminApi(baseUrl: String) extends CirceSchema {

  /** Add a new Role
    *
    * Expected answers: code 200 : Role () code 400 : String (Invalid value for: body) code 0 : ErrorDescription () Headers : x-error-code - Error Code
    * x-error-message - Message of the MongoCampException x-error-additional-info - Additional information for the MongoCampException
    *
    * Available security schemes: httpAuth1 (http) httpAuth (http) apiKeyAuth (apiKey)
    *
    * @param role
    */
  def addRole(username: String, password: String, bearerToken: String, apiKey: String)(role: Role) =
    basicRequest
      .method(Method.PUT, uri"$baseUrl/admin/roles")
      .contentType("application/json")
      .auth
      .basic(username, password)
      .auth
      .bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .body(role)
      .response(asJson[Role])

  /** Add a new User
    *
    * Expected answers: code 200 : UserProfile () code 400 : String (Invalid value for: body) code 0 : ErrorDescription () Headers : x-error-code - Error Code
    * x-error-message - Message of the MongoCampException x-error-additional-info - Additional information for the MongoCampException
    *
    * Available security schemes: httpAuth1 (http) httpAuth (http) apiKeyAuth (apiKey)
    *
    * @param userInformation
    */
  def addUser(username: String, password: String, bearerToken: String, apiKey: String)(
      userInformation: UserInformation
  ) =
    basicRequest
      .method(Method.PUT, uri"$baseUrl/admin/users")
      .contentType("application/json")
      .auth
      .basic(username, password)
      .auth
      .bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .body(userInformation)
      .response(asJson[UserProfile])

  /** Delete Role
    *
    * Expected answers: code 200 : JsonValueBoolean () code 0 : ErrorDescription () Headers : x-error-code - Error Code x-error-message - Message of the
    * MongoCampException x-error-additional-info - Additional information for the MongoCampException
    *
    * Available security schemes: httpAuth1 (http) httpAuth (http) apiKeyAuth (apiKey)
    *
    * @param roleName
    *   RoleKey
    */
  def deleteRole(username: String, password: String, bearerToken: String, apiKey: String)(
      roleName: String
  ) =
    basicRequest
      .method(Method.DELETE, uri"$baseUrl/admin/roles/${roleName}")
      .contentType("application/json")
      .auth
      .basic(username, password)
      .auth
      .bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[JsonValueBoolean])

  /** Delete User
    *
    * Expected answers: code 200 : JsonValueBoolean () code 0 : ErrorDescription () Headers : x-error-code - Error Code x-error-message - Message of the
    * MongoCampException x-error-additional-info - Additional information for the MongoCampException
    *
    * Available security schemes: httpAuth1 (http) httpAuth (http) apiKeyAuth (apiKey)
    *
    * @param userId
    *   UserId to Delete
    */
  def deleteUser(username: String, password: String, bearerToken: String, apiKey: String)(userId: String) =
    basicRequest
      .method(Method.DELETE, uri"$baseUrl/admin/users/${userId}")
      .contentType("application/json")
      .auth
      .basic(username, password)
      .auth
      .bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[JsonValueBoolean])

  /** Get Role by RoleKey
    *
    * Expected answers: code 200 : Role () code 0 : ErrorDescription () Headers : x-error-code - Error Code x-error-message - Message of the MongoCampException
    * x-error-additional-info - Additional information for the MongoCampException
    *
    * Available security schemes: httpAuth1 (http) httpAuth (http) apiKeyAuth (apiKey)
    *
    * @param roleName
    *   RoleKey to search
    */
  def getRole(username: String, password: String, bearerToken: String, apiKey: String)(roleName: String) =
    basicRequest
      .method(Method.GET, uri"$baseUrl/admin/roles/${roleName}")
      .contentType("application/json")
      .auth
      .basic(username, password)
      .auth
      .bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[Role])

  /** Get UserProfile for user
    *
    * Expected answers: code 200 : UserProfile () code 0 : ErrorDescription () Headers : x-error-code - Error Code x-error-message - Message of the
    * MongoCampException x-error-additional-info - Additional information for the MongoCampException
    *
    * Available security schemes: httpAuth1 (http) httpAuth (http) apiKeyAuth (apiKey)
    *
    * @param userId
    *   UserId to search
    */
  def getUser(username: String, password: String, bearerToken: String, apiKey: String)(userId: String) =
    basicRequest
      .method(Method.GET, uri"$baseUrl/admin/users/${userId}")
      .contentType("application/json")
      .auth
      .basic(username, password)
      .auth
      .bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[UserProfile])

  /** Generate an new APIkey for the user
    *
    * Expected answers: code 200 : JsonValueString () code 0 : ErrorDescription () Headers : x-error-code - Error Code x-error-message - Message of the
    * MongoCampException x-error-additional-info - Additional information for the MongoCampException
    *
    * Available security schemes: httpAuth1 (http) httpAuth (http) apiKeyAuth (apiKey)
    *
    * @param userId
    *   UserId to Update
    */
  def gnerateNewApiKeyForUser(username: String, password: String, bearerToken: String, apiKey: String)(userId: String) =
    basicRequest
      .method(Method.PATCH, uri"$baseUrl/admin/users/${userId}/apikey")
      .contentType("application/json")
      .auth
      .basic(username, password)
      .auth
      .bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[JsonValueString])

  /** List all Roles or filtered
    *
    * Expected answers: code 200 : Seq[Role] () Headers : x-pagination-count-rows - count all elements x-pagination-rows-per-page - Count elements per page
    * x-pagination-current-page - Current page x-pagination-count-pages - Count pages code 400 : String (Invalid value for: query parameter filter, Invalid
    * value for: query parameter rowsPerPage, Invalid value for: query parameter page) code 0 : ErrorDescription () Headers : x-error-code - Error Code
    * x-error-message - Message of the MongoCampException x-error-additional-info - Additional information for the MongoCampException
    *
    * Available security schemes: httpAuth1 (http) httpAuth (http) apiKeyAuth (apiKey)
    *
    * @param filter
    *   filter after userId by contains
    * @param rowsPerPage
    *   Count elements per page
    * @param page
    *   Requested page of the ResultSets
    */
  def listRoles(username: String, password: String, bearerToken: String, apiKey: String)(
      filter: Option[String] = None,
      rowsPerPage: Option[Long] = None,
      page: Option[Long] = None
  ) =
    basicRequest
      .method(Method.GET, uri"$baseUrl/admin/roles?filter=${filter}&rowsPerPage=${rowsPerPage}&page=${page}")
      .contentType("application/json")
      .auth
      .basic(username, password)
      .auth
      .bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[Seq[Role]])

  /** List all Users or filtered
    *
    * Expected answers: code 200 : Seq[UserProfile] () Headers : x-pagination-count-rows - count all elements x-pagination-rows-per-page - Count elements per
    * page x-pagination-current-page - Current page x-pagination-count-pages - Count pages code 400 : String (Invalid value for: query parameter filter, Invalid
    * value for: query parameter rowsPerPage, Invalid value for: query parameter page) code 0 : ErrorDescription () Headers : x-error-code - Error Code
    * x-error-message - Message of the MongoCampException x-error-additional-info - Additional information for the MongoCampException
    *
    * Available security schemes: httpAuth1 (http) httpAuth (http) apiKeyAuth (apiKey)
    *
    * @param filter
    *   filter after userId by contains
    * @param rowsPerPage
    *   Count elements per page
    * @param page
    *   Requested page of the ResultSets
    */
  def listUsers(username: String, password: String, bearerToken: String, apiKey: String)(
      filter: Option[String] = None,
      rowsPerPage: Option[Long] = None,
      page: Option[Long] = None
  ) =
    basicRequest
      .method(Method.GET, uri"$baseUrl/admin/users?filter=${filter}&rowsPerPage=${rowsPerPage}&page=${page}")
      .contentType("application/json")
      .auth
      .basic(username, password)
      .auth
      .bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .response(asJson[Seq[UserProfile]])

  /** Change Password of User
    *
    * Expected answers: code 200 : JsonValueBoolean () code 400 : String (Invalid value for: body) code 0 : ErrorDescription () Headers : x-error-code - Error
    * Code x-error-message - Message of the MongoCampException x-error-additional-info - Additional information for the MongoCampException
    *
    * Available security schemes: httpAuth1 (http) httpAuth (http) apiKeyAuth (apiKey)
    *
    * @param userId
    *   UserId to Update
    * @param passwordUpdateRequest
    */
  def updatePasswordForUser(username: String, password: String, bearerToken: String, apiKey: String)(
      userId: String,
      passwordUpdateRequest: PasswordUpdateRequest
  ) =
    basicRequest
      .method(Method.PATCH, uri"$baseUrl/admin/users/${userId}/password")
      .contentType("application/json")
      .auth
      .basic(username, password)
      .auth
      .bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .body(passwordUpdateRequest)
      .response(asJson[JsonValueBoolean])

  /** Update Role
    *
    * Expected answers: code 200 : Role () code 400 : String (Invalid value for: body) code 0 : ErrorDescription () Headers : x-error-code - Error Code
    * x-error-message - Message of the MongoCampException x-error-additional-info - Additional information for the MongoCampException
    *
    * Available security schemes: httpAuth1 (http) httpAuth (http) apiKeyAuth (apiKey)
    *
    * @param roleName
    *   RoleKey
    * @param updateRoleRequest
    */
  def updateRole(username: String, password: String, bearerToken: String, apiKey: String)(
      roleName: String,
      updateRoleRequest: UpdateRoleRequest
  ) =
    basicRequest
      .method(Method.PATCH, uri"$baseUrl/admin/roles/${roleName}")
      .contentType("application/json")
      .auth
      .basic(username, password)
      .auth
      .bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .body(updateRoleRequest)
      .response(asJson[Role])

  /** Update Roles of User
    *
    * Expected answers: code 200 : UserProfile () code 400 : String (Invalid value for: body) code 0 : ErrorDescription () Headers : x-error-code - Error Code
    * x-error-message - Message of the MongoCampException x-error-additional-info - Additional information for the MongoCampException
    *
    * Available security schemes: httpAuth1 (http) httpAuth (http) apiKeyAuth (apiKey)
    *
    * @param userId
    *   UserId to Update
    * @param requestBody
    */
  def updateRolesForUser(username: String, password: String, bearerToken: String, apiKey: String)(
      userId: String,
      requestBody: Seq[String]
  ) =
    basicRequest
      .method(Method.PATCH, uri"$baseUrl/admin/users/${userId}/roles")
      .contentType("application/json")
      .auth
      .basic(username, password)
      .auth
      .bearer(bearerToken)
      .header("X-AUTH-APIKEY", apiKey)
      .body(requestBody)
      .response(asJson[UserProfile])

}
