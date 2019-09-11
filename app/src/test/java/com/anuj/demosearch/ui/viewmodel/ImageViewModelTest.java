package com.anuj.demosearch.ui.viewmodel;

import com.anuj.demosearch.business.model.ImageDomainModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ImageViewModelTest {

    private static final String SOME_URL = "URL";
    private static final String SOME_SIZE = "SIZE";

    @Mock ImageDomainModel mImageDomainModel;

    @Test
    public void fromList_whenCalled_shouldReturnViewModelList() {
        when(mImageDomainModel.getUrl()).thenReturn(SOME_URL);
        when(mImageDomainModel.getSize()).thenReturn(SOME_SIZE);

        final List<ImageViewModel> imageViewModels =
                ImageViewModel.fromList(Collections.singletonList(mImageDomainModel));

        final int index = 0;
        assertEquals(SOME_URL, imageViewModels.get(index).getImageUrl());
        assertEquals(SOME_SIZE, imageViewModels.get(index).getSize());
    }
}