/** mongocamp-server No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
  *
  * The version of the OpenAPI document: 1.4.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech). https://openapi-generator.tech Do not edit the class manually.
  */
package dev.mongocamp.server.test.client.model

import org.joda.time.DateTime

case class CollectionStatus(
    ns: String,
    collectionType: String,
    scaleFactor: Int,
    size: Double,
    count: Int,
    storageSize: Double,
    avgObjSize: Int,
    nindexes: Int,
    indexSizes: Map[String, Int],
    totalIndexSize: Int,
    ok: Int,
    fetched: DateTime,
    map: Map[String, Any]
)
