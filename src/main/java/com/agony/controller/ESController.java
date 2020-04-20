package com.agony.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * desc
 *
 * @author agony
 * @date 2020/4/19 22:46
 */
@RestController
@RequestMapping("/accounts/person")
public class ESController {

    private static final Log logger = LogFactory.getLog(ESController.class);

    @Autowired
    private TransportClient client;

    @GetMapping("/{id}")
    public String getById(@PathVariable String id) {
        return client.prepareGet("accounts", "person", id).get().getSourceAsString();
    }

    @PostMapping("/{id}")
    public ResponseEntity add(@PathVariable String id
            , @RequestParam(name = "user") String user
            , @RequestParam(name = "title") String title
            , @RequestParam(name = "desc") String desc) {
        try {
            XContentBuilder content = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("user", user)
                    .field("title", title)
                    .field("desc", desc)
                    .endObject();
            IndexResponse result = client.prepareIndex("accounts", "person", id).setSource(content).get();
            return new ResponseEntity(result.getResult().toString(), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateById(@PathVariable String id
            , @RequestParam(name = "user") String user
            , @RequestParam(name = "title") String title
            , @RequestParam(name = "desc") String desc) {
        try {
            UpdateRequest update = new UpdateRequest("accounts", "person", id);
            XContentBuilder content = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("user", user)
                    .field("title", title)
                    .field("desc", desc)
                    .endObject();
            update.doc(content);
            UpdateResponse result = client.update(update).get();
            return new ResponseEntity(result.getResult().toString(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable String id) {
        return client.prepareDelete("accounts", "person", id).get().getResult().toString();
    }

    @PostMapping("/query")
    public ResponseEntity query(@RequestParam(name = "user") String user
            , @RequestParam(name = "title") String title
            , @RequestParam(name = "desc") String desc) {
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolQuery.must(QueryBuilders.matchQuery("user", user));
        boolQuery.must(QueryBuilders.matchQuery("title", title));
        boolQuery.must(QueryBuilders.matchQuery("desc", desc));
        SearchRequestBuilder searchRequest = client.prepareSearch("accounts").setTypes("person")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(boolQuery)
                .setFrom(0)
                .setSize(10);
        logger.info(searchRequest);
        List<Map<String, Object>> result = new ArrayList<>();
        SearchResponse searchResponse = searchRequest.get();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            result.add(hit.getSource());
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
