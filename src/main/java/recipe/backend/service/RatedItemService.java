package recipe.backend.service;


import org.springframework.data.domain.Page;
import recipe.backend.entity.RatedItem;

public interface RatedItemService {
    Page<RatedItem> getRatedItem(Integer pageSize, Integer page);
    RatedItem getRatedItem(Long id);
    RatedItem save(RatedItem ratedItem);
}
