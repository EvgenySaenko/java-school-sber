package ru.socialnetwork.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import ru.socialnetwork.persist.entities.Audio;
import ru.socialnetwork.repositories.AudioRepository;
import ru.socialnetwork.repositories.AudioRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class AudioServiceTest {

    private AudioRepository audioRepository;

    private AudioRepository audioRepositoryMock;

    private List<Audio> audioCorrect;

    @Before
    public void setUp() throws Exception {

        this.audioRepository = new AudioRepositoryImpl();

        audioRepositoryMock = Mockito.mock(AudioRepositoryImpl.class);

        this.audioCorrect =  new ArrayList<>();
        audioCorrect.add(new Audio(1L,"Она не такая","Dabro"));
        audioCorrect.add(new Audio(2L,"На крыше","Dabro"));
        audioCorrect.add(new Audio(4L,"Юность","Dabro"));
    }

    @Test
    public void getOneByIdReturnedMatch() {
        Audio audio = audioRepository.getOneById(1L);
        Assert.assertNotNull(audio);
        Assert.assertEquals(new Audio(1L,"Она не такая","Dabro"),audio);
    }

    @Test
    public void getOneByNameReturnedMatch() {
        Audio audio = audioRepository.getOneByName("Она не такая");
        Assert.assertNotNull(audio);
        Assert.assertEquals(new Audio(1L,"Она не такая","Dabro"),audio);

    }

    @Test
    public void getListAudioBySingerReturnedMatch() {
        List<Audio> dabro = audioRepository.getListAudioBySinger("Dabro");
        Assert.assertNotNull(dabro);
        Assert.assertEquals(3,dabro.size());
        //сравнение списков через жунит
        assertTrue(audioCorrect.size() == dabro.size() && audioCorrect.containsAll(dabro) && dabro.containsAll(audioCorrect));

        //сравнение списков ччерез хамкрест
        assertThat(audioCorrect,containsInAnyOrder(dabro.toArray()));
    }

    @Test
    public void checkAudioPresenceById() throws Exception{
        audioRepositoryMock.getOneById(1L);
        audioRepositoryMock.getOneById(1L);
        Mockito.when(audioRepositoryMock.getOneById(1L)).thenReturn(new Audio(1L,"Она не такая","Dabro"));

        //Mockito.verify(audioRepositoryMock).getOneById(1L);

        //проверка что метод вызван был 2 раза
        Mockito.verify(audioRepositoryMock,Mockito.atLeast(2)).getOneById(1L);

    }

    @Test
    public void checkAudioPresenceByName() throws Exception{
        audioRepositoryMock.getOneByName("Она не такая");
        Mockito.when(audioRepositoryMock.getOneByName("Она не такая")).thenReturn(new Audio(1L,"Она не такая","Dabro"));
        Mockito.verify(audioRepositoryMock).getOneByName(Mockito.any());
    }

    @Test
    public void checkAudioPresenceBySinger() throws Exception{
        audioRepositoryMock.getListAudioBySinger("Dabro");
        Mockito.when(audioRepositoryMock.getListAudioBySinger("Dabro")).thenReturn(audioCorrect);
        Mockito.verify(audioRepositoryMock).getListAudioBySinger(Mockito.any());
    }
}