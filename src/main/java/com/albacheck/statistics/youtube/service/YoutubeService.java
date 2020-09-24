package com.albacheck.statistics.youtube.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class YoutubeService {

  public void getSubscriber() {

  }

  public void getTotalView() {

  }

  public void getTotalVideo() {

  }
//  // todo: application 인 Admin 에서는 Entity 를 모르게 만드려고 했으나,
//  // Core 에 BrandService 가 없고, 만들 경우 영향도가 클 것으로 예상되어 여기서 구현
//  public UpdateStoreByExcelRes updateStoreByExcel(List<StoreExcelDto> storeExcelDtoList) {
//    List<BrandStoreDto> alreadyExistStoreList = new ArrayList<>();
//    List<BrandStoreDto> updatedStoreList = new ArrayList<>();
//    List<BrandStoreDto> createdStoreList = new ArrayList<>();
//
//    storeExcelDtoList.forEach(dto -> {
//          brandStoreRepository.findByBrandIdAndCode(BrandStoreType.GS25.getBrandId(), dto.getCode())
//              .ifPresentOrElse(
//                  entity -> {
//                    if (isEqual(dto, entity)) {
//                      alreadyExistStoreList.add(BrandStoreDto.of(entity));
//                    } else {
//                      entity.setBranchName(dto.getName());
//                      entity.setAddress(dto.getAddress());
//                      BrandStoreDto brandStoreDto = BrandStoreDto.of(entity);
//                      updatedStoreList.add(update(brandStoreDto));
//                    }
//                  },
//                  () -> {
//                    BrandStoreDto brandStoreDto = BrandStoreDto
//                        .of(dto.getCode(), dto.getName(), dto.getAddress(), BrandStoreType.GS25.getBrandId());
//                    createdStoreList.add(create(brandStoreDto));
//                  }
//              );
//        }
//    );
//
//    return UpdateStoreByExcelRes
//        .of(alreadyExistStoreList.stream().map(StoreExcelDto::of).collect(Collectors.toList()),
//            updatedStoreList.stream().map(StoreExcelDto::of).collect(Collectors.toList()),
//            createdStoreList.stream().map(StoreExcelDto::of).collect(Collectors.toList()));
//  }
}
