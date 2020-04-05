package md.ciocana.controller;

import lombok.RequiredArgsConstructor;
import md.ciocana.dto.GroupDTO;
import md.ciocana.model.Group;
import md.ciocana.service.GroupService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GroupController {

    final private GroupService groupService;

    @GetMapping(value = "/getAllGroups", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Group>> getAllGroups(){
        return ResponseEntity.ok().body(groupService.getAllGroups());
    }

    @PostMapping(value = "/saveGroup", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> saveGroup(@RequestBody GroupDTO groupDTO) {
        Group group = new Group();
        group.setGroupName(groupDTO.getGroupName());
        groupService.save(group);
        return ResponseEntity.ok().body(group);
    }
}
