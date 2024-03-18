package recipe.backend.controller;

import lombok.RequiredArgsConstructor;
import recipe.backend.entity.RatedItem;
import recipe.backend.service.RatedItemService;
import recipe.backend.util.LabMapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequiredArgsConstructor
public class RatedItemController {
    @Autowired
    final RatedItemService ratedItemService;

    @PostMapping("/ratedItem")
    public ResponseEntity<?> addRatedItem(@RequestBody RatedItem item){
        RatedItem output = ratedItemService.save(item);
        return ResponseEntity.ok(LabMapper.INSTANCE.getRatedItemDTO(output));
    }
}
