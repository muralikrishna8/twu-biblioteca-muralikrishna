package com.twu.biblioteca;

import com.twu.biblioteca.menu.Librarian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
    @Mock
    Section section;
    @Mock
    BibliotecaIO bibliotecaIO;
    @Mock
    Authenticator authenticator;
    @Mock
    Customer customer;

    private Controller controller;

    @Before
    public void setUp() {
        controller = new Controller(bibliotecaIO, authenticator);
    }

    @Test
    public void shouldPromptTheUserToEnterBookToCheckOut() {
        controller.checkOut(section, Messages.BOOK_CHECKOUT_SUCCESSFUL, Messages.BOOK_CHECKOUT_UNSUCCESSFUL);

        verify(bibliotecaIO).print(Messages.CHECKOUT_PROMPT);
    }

    @Test
    public void shouldReadTheBookNameWhenCheckOutMethodCalled() {
        controller.checkOut(section, Messages.BOOK_CHECKOUT_SUCCESSFUL, Messages.BOOK_CHECKOUT_UNSUCCESSFUL);

        verify(bibliotecaIO).read();
    }

    @Test
    public void shouldCallCheckoutMethodInLibraryOnCheckOut() {
        when(bibliotecaIO.read()).thenReturn("Book1");
        controller.checkOut(section, Messages.BOOK_CHECKOUT_SUCCESSFUL, Messages.BOOK_CHECKOUT_UNSUCCESSFUL);

        verify(section).checkout("Book1", Messages.BOOK_CHECKOUT_SUCCESSFUL, Messages.BOOK_CHECKOUT_UNSUCCESSFUL);
        verify(bibliotecaIO, times(4)).print(Matchers.anyString());
    }

    @Test
    public void shouldPromptTheUserToEnterBookToReturnABook() {
        controller.returnItem(section, Messages.BOOK_RETURN_SUCCESSFUL, Messages.BOOK_RETURN_UNSUCCESSFUL);

        verify(bibliotecaIO).print(Messages.RETURN_PROMPT);
    }

    @Test
    public void shouldReadTheBookNameWhenReturningBook() {
        controller.returnItem(section, Messages.BOOK_RETURN_SUCCESSFUL, Messages.BOOK_RETURN_UNSUCCESSFUL);

        verify(bibliotecaIO).read();
    }

    @Test
    public void shouldCallReturnBookMethodInLibraryOnReturningABook() {
        when(bibliotecaIO.read()).thenReturn("Book1");
        controller.returnItem(section, Messages.BOOK_RETURN_SUCCESSFUL, Messages.BOOK_RETURN_UNSUCCESSFUL);

        verify(section).returnItem("Book1", Messages.BOOK_RETURN_SUCCESSFUL, Messages.BOOK_RETURN_UNSUCCESSFUL);
        verify(bibliotecaIO, times(4)).print(Matchers.anyString());
    }

    @Test
    public void shouldCallBooksClassInLibraryToDisplayAllBooks() {
        controller.displayListOfItems(section);

        verify(section).availableItems();
    }

    @Test
    public void shouldCallUserClassForPrintingUserDetails() {
        controller.displayUserDetails(customer);

        verify(bibliotecaIO).print(customer.details());
    }
}