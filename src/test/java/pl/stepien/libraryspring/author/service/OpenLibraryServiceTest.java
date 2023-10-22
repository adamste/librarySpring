package pl.stepien.libraryspring.author.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OpenLibraryServiceTest {

    @InjectMocks
    OpenLibraryService openLibraryService;

    @Test
    public void testByOlid() {
        String automotive = openLibraryService.worksByOlid("OL53924W");
        Assertions.assertFalse(automotive.isEmpty());
    }

    //https://github.com/rickardzettervall/openlibrary-api-rxclient/tree/master
}