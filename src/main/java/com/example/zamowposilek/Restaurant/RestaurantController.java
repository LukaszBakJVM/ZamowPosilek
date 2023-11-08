package com.example.zamowposilek.Restaurant;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantServices restaurantServices;
    private final ObjectMapper objectMapper;

    public RestaurantController(RestaurantServices restaurantServices, ObjectMapper objectMapper) {
        this.restaurantServices = restaurantServices;
        this.objectMapper = objectMapper;
    }
    @PostMapping
    ResponseEntity<ResAddDto>save(@RequestBody ResAddDto resAddDto){
        ResAddDto resAdd = restaurantServices.save(resAddDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(resAdd.getRestaurantId()).toUri();
        return ResponseEntity.created(uri).body(resAdd);
    }
    @GetMapping("/{id}")
    ResponseEntity<ResAddDto>findById(@PathVariable long id){
    return ResponseEntity .ok(restaurantServices.findByIb(id));
    }



    @PatchMapping("/{id}")
    ResponseEntity<?> updateJobOffer(@PathVariable Long id, @RequestBody JsonMergePatch patch) {
        try {
            ResAddDto byIb = restaurantServices.findByIb(id);
            ResAddDto resAddDto = applyPatch(byIb, patch);
            restaurantServices.updateRestaurant(resAddDto);

        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.internalServerError().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    private ResAddDto applyPatch(ResAddDto resAddDto, JsonMergePatch patch) throws JsonPatchException, JsonProcessingException {

        JsonNode jsonNode = objectMapper.valueToTree(resAddDto);
        JsonNode jobOfferPatchedNode = patch.apply(jsonNode);
        return objectMapper.treeToValue(jobOfferPatchedNode, ResAddDto.class);
    }
}
