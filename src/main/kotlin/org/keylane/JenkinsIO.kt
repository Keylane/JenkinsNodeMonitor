package org.keylane

import khttp.get
import khttp.structures.authorization.BasicAuthorization
import org.json.JSONArray
import org.json.JSONObject


class JenkinsIO {
    fun getJenkinsNodes() : JSONArray{
        val r = get("http://build.life.schantz.com/computer/api/json")
        val json = r.jsonObject
        return getNodesNames((json["computer"] as JSONArray))
    }

    fun getNodesNames(json : JSONArray): JSONArray {
        var nodes = JSONArray()
        for (node in json) {
            if(node is JSONObject){
                val j = JSONObject()
                    .put("name", node["displayName"])
                    .put("executors", node["numExecutors"])
                    .put("online", node["offline"])
                nodes.put(j)
            }


        }
        return nodes
    }

}