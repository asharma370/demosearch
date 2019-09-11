package com.anuj.demosearch.ui.viewmodel;

import com.anuj.demosearch.business.model.ImageDomainModel;
import com.anuj.demosearch.business.model.TrackDomainModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrackViewModelTest {

    private static final String ARTIST = "Artist";
    private static final String LISTENERS = "Listeners";
    private static final String NAME = "Name";
    private static final String STREAMABLE = "StreamAble";
    private static final String URL = "URL";
    private static final String EMPTY_STRING = "";
    private static final int INDEX = 0;

    @Mock TrackDomainModel mTrackDomainModel;
    @Mock ImageDomainModel mImageDomainModel;

    @Test
    public void fromDomainModel() {
        when(mTrackDomainModel.getArtist()).thenReturn(ARTIST);
        when(mTrackDomainModel.getImage()).thenReturn(Collections.singletonList(mImageDomainModel));
        when(mTrackDomainModel.getListeners()).thenReturn(LISTENERS);
        when(mTrackDomainModel.getName()).thenReturn(NAME);
        when(mTrackDomainModel.getStreamable()).thenReturn(STREAMABLE);
        when(mTrackDomainModel.getUrl()).thenReturn(URL);

        final List<TrackViewModel> trackViewModels =
                TrackViewModel.fromDomainModel(Collections.singletonList(mTrackDomainModel));
        assertEquals(ARTIST, trackViewModels.get(INDEX).getArtistName());
        assertEquals(NAME, trackViewModels.get(INDEX).getName());
        assertEquals(LISTENERS, trackViewModels.get(INDEX).getListeners());
        assertEquals(STREAMABLE, trackViewModels.get(INDEX).getStreamable());
        assertEquals(URL, trackViewModels.get(INDEX).getUrl());
    }

    @Test
    public void getSmallImage_whenSmallImageAvailable_shouldReturnUrl() {
        when(mImageDomainModel.getUrl()).thenReturn(URL);
        when(mImageDomainModel.getSize()).thenReturn(NAME);
        final List<ImageDomainModel> imageDomainModels = Collections.singletonList(mImageDomainModel);
        when(mTrackDomainModel.getImage()).thenReturn(imageDomainModels);

        final List<TrackViewModel> trackViewModels =
                TrackViewModel.fromDomainModel(Collections.singletonList(mTrackDomainModel));

        assertEquals(imageDomainModels.size(), trackViewModels.get(INDEX).getImage().size());
        assertEquals(URL, trackViewModels.get(INDEX).getImage().get(INDEX).getImageUrl());
        assertEquals(NAME, trackViewModels.get(INDEX).getImage().get(INDEX).getSize());
        assertEquals(URL, trackViewModels.get(INDEX).getSmallImage());
    }

    @Test
    public void getSmallImage_whenSmallImageNotAvailable_shouldReturnEmpty() {
        final List<ImageDomainModel> imageDomainModels = Collections.emptyList();
        when(mTrackDomainModel.getImage()).thenReturn(imageDomainModels);

        final List<TrackViewModel> trackViewModels =
                TrackViewModel.fromDomainModel(Collections.singletonList(mTrackDomainModel));

        assertEquals(imageDomainModels.size(), trackViewModels.get(0).getImage().size());
        assertEquals(EMPTY_STRING, trackViewModels.get(0).getSmallImage());
    }

    @Test
    public void getLargeImage_whenLargeImageAvailable_shouldReturnLargeImageUrl() {
        when(mImageDomainModel.getUrl()).thenReturn(URL);
        when(mImageDomainModel.getSize()).thenReturn(NAME);
        final List<ImageDomainModel> imageDomainModels = new ArrayList<>();
        imageDomainModels.add(mImageDomainModel);
        imageDomainModels.add(mImageDomainModel);
        imageDomainModels.add(mImageDomainModel);
        when(mTrackDomainModel.getImage()).thenReturn(imageDomainModels);

        final List<TrackViewModel> trackViewModels =
                TrackViewModel.fromDomainModel(Collections.singletonList(mTrackDomainModel));

        assertEquals(imageDomainModels.size(), trackViewModels.get(INDEX).getImage().size());
        assertEquals(URL, trackViewModels.get(INDEX).getImage().get(INDEX).getImageUrl());
        assertEquals(NAME, trackViewModels.get(INDEX).getImage().get(INDEX).getSize());
        assertEquals(URL, trackViewModels.get(INDEX).getLargeImage());
    }

    @Test
    public void getLargeImage_whenLargeNotImageAvailable_shouldReturnEmpty() {
        when(mImageDomainModel.getUrl()).thenReturn(URL);
        when(mImageDomainModel.getSize()).thenReturn(NAME);
        final List<ImageDomainModel> imageDomainModels = new ArrayList<>();
        imageDomainModels.add(mImageDomainModel);
        imageDomainModels.add(mImageDomainModel);
        when(mTrackDomainModel.getImage()).thenReturn(imageDomainModels);

        final List<TrackViewModel> trackViewModels =
                TrackViewModel.fromDomainModel(Collections.singletonList(mTrackDomainModel));

        assertEquals(imageDomainModels.size(), trackViewModels.get(INDEX).getImage().size());
        assertEquals(URL, trackViewModels.get(INDEX).getImage().get(INDEX).getImageUrl());
        assertEquals(NAME, trackViewModels.get(INDEX).getImage().get(INDEX).getSize());
        assertEquals(EMPTY_STRING, trackViewModels.get(INDEX).getLargeImage());
    }
}