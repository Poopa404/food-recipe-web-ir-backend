package recipe.backend.service;

import lombok.RequiredArgsConstructor;
import recipe.backend.dao.FolderDao;
import recipe.backend.dao.RatedItemDao;
import recipe.backend.entity.Folder;
import recipe.backend.entity.RatedItem;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class RatedItemServiceImpl implements RatedItemService {
    final RatedItemDao ratedItemDao;
    final FolderDao folderDao;
    final FolderService folderService;
    final UserAccountService userAccountService;

    @Override
    public Page<RatedItem> getRatedItem(Integer pageSize, Integer page) {
        return ratedItemDao.getRatedItem(pageSize, page);
    }

    @Override
    public RatedItem getRatedItem(Long id) {
        return ratedItemDao.getRatedItem(id);
    }

    @Override
    @Transactional
    public RatedItem save(RatedItem item) {
        RatedItem saveItem = ratedItemDao.save(item);
        if(item.getFolder() != null && item.getFolder().getId() != null){
            Folder folder = folderService.getFolder(item.getFolder().getId());
            folder.getRecipeList().add(saveItem);
            folderService.save(folder);
        }
        return saveItem;
    }

}