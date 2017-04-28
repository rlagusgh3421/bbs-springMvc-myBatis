package com.khh.web;

import com.khh.domain.Reply;
import com.khh.service.ReplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hyunhokim on 2017. 4. 27..
 */
@RestController
@RequestMapping("/replies")
public class RepliesController {

    private static final Logger logger = LoggerFactory.getLogger(RepliesController.class);

    @Autowired
    private ReplyService replyService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody Reply reply) {
        logger.info("reply register .....");
        ResponseEntity<String> entity;

        try {
            replyService.register(reply);
            entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @RequestMapping(value = "/all/{bno}", method = RequestMethod.GET)
    public ResponseEntity<List<Reply>> list(@PathVariable("bno") int bno) {
        logger.info("reply list .....");

        ResponseEntity<List<Reply>> entity;

        try {
            entity = new ResponseEntity<>(
                    replyService.list(bno), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @RequestMapping(value = "/{rno}", method = { RequestMethod.PUT, RequestMethod.PATCH })
    public ResponseEntity<String> modify(
            @PathVariable("rno") int rno,
            @RequestBody Reply reply) {

        logger.info("reply modify .....");

        ResponseEntity<String> entity;

        try {
            reply.setRno(rno);
            replyService.modify(reply);

            entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(
                    e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @RequestMapping(value = "/{rno}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("rno") int rno) {

        logger.info("reply delete .....");

        ResponseEntity<String> entity;

        try {
            replyService.delete(rno);
            entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
}
