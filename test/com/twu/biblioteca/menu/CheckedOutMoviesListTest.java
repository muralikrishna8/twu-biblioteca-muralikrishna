package com.twu.biblioteca.menu;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckedOutMoviesListTest {
    @Mock
    Controller controller;
    @Mock
    Customer customer;

    @Test
    public void shouldDelegateTheDisplayingOfCheckedOutMoviesToController() {
        CheckedOutMoviesList checkedOutMoviesList = new CheckedOutMoviesList(controller);

        checkedOutMoviesList.performAction(customer);

        verify(controller).displayCheckedOutMoviesList();
    }

}