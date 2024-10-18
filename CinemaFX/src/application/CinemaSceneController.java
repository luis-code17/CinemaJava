package application;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Cinema;
import model.ICinema;
import model.IMovie;
import model.ISeat;
import model.ISession;
import model.ITheater;
import model.SeatAlreadyBookedException;

/**
 * @luis
 * Controller class for the Cinema Scene in the application.
 * Handles user interactions and updates the UI components accordingly.
 * Implements the Initializable interface to perform initialization logic.
 */
public class CinemaSceneController implements Initializable {
    private ICinema cinema;

    // MOVIE
    @FXML
    private ListView<IMovie> listMovies;
    @FXML
    private TextField textFieldMoviesName;
    @FXML
    private TextField textFieldMoviesAuthor;
    @FXML
    private TextField textFieldMoviesDuration;

    // THEATER
    @FXML
    private TextField textFieldTheaterCapacity;
    @FXML
    private ListView<ITheater> listTheaters;

    // SESSION
    @FXML
    private ListView<ISession> listSessions;
    @FXML
    private TextField textFieldTheaterID;
    @FXML
    private TextField textFieldMovieID;
    @FXML
    private TextField textFieldDate;

    // SEATS
    @FXML
    private ListView<ISession> listSeats;
    @FXML
    private TextField textFieldSeatNumber;
    @FXML
    private TextField textFieldIdSession;

    /**
     * Initializes the controller class.
     * This method is called automatically after the fxml file has been loaded.
     *
     * @param arg0 The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param arg1 The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cinema = new Cinema();
        cinema.addMovie("La Venganza de los Sabores", "Steven Spielberg", 180);
        cinema.addMovie("La Última Cucharada", "Christopher Nolan", 160);
        cinema.addMovie("Dulce Tentación", "Quentin Tarantino", 140);
        cinema.addMovie("El Secreto del Helado Perfecto", "Martin Scorsese", 130);
        cinema.addMovie("El Misterio de la Receta", "David Fincher", 135);
        updateMoviesListView();
    }

    /**
     * Updates the ListView of movies with the current list of movies from the cinema.
     */
    public void updateMoviesListView() {
        ObservableList<IMovie> movies = FXCollections.observableList(cinema.getMovies());
        listMovies.setItems(movies);
    }

    /**
     * Gets the movie name input from the corresponding TextField.
     *
     * @return The movie name entered by the user.
     */
    public String getMovieInputName() {
        return textFieldMoviesName.getText();
    }

    /**
     * Gets the movie author input from the corresponding TextField.
     *
     * @return The movie author entered by the user.
     */
    public String getMovieInputAuthor() {
        return textFieldMoviesAuthor.getText();
    }

    /**
     * Gets the movie duration input from the corresponding TextField.
     *
     * @return The movie duration entered by the user.
     */
    public int getMovieInputDuration() {
        return Integer.parseInt(textFieldMoviesDuration.getText());
    }

    /**
     * Handles the action when the add movie button is clicked.
     *
     * @param event The ActionEvent triggered by clicking the button.
     */
    @FXML
    public void btnMoviesAdd(ActionEvent event) {
        String name = getMovieInputName();
        String author = getMovieInputAuthor();
        int duration = getMovieInputDuration();
        cinema.addMovie(name, author, duration);
        updateMoviesListView();
    }

    /**
     * Handles the action when the edit movie button is clicked.
     *
     * @param event The ActionEvent triggered by clicking the button.
     */
    @FXML
    public void btnMoviesEdit(ActionEvent event) {
        int movieId = listMovies.getSelectionModel().getSelectedItem().getId();
        String newName = getMovieInputName();
        String newAuthor = getMovieInputAuthor();
        int duration = getMovieInputDuration();
        cinema.updateMovie(movieId, newName, newAuthor, duration);
        updateMoviesListView();
    }

    /**
     * Handles the action when the delete movie button is clicked.
     *
     * @param event The ActionEvent triggered by clicking the button.
     */
    @FXML
    public void btnMoviesDelete(ActionEvent event) {
        int movieId = listMovies.getSelectionModel().getSelectedItem().getId();
        cinema.deleteMovie(movieId);
        updateMoviesListView();
    }

    /**
     * Updates the ListView of theaters with the current list of theaters from the cinema.
     */
    public void updateTheaterListView() {
        ObservableList<ITheater> theaters = FXCollections.observableList(cinema.getTheaters());
        listTheaters.setItems(theaters);
    }

    /**
     * Gets the theater capacity input from the corresponding TextField.
     *
     * @return The theater capacity entered by the user.
     */
    public int getTheaterInputCapacity() {
        return Integer.parseInt(textFieldTheaterCapacity.getText());
    }

    /**
     * Handles the action when the add theater button is clicked.
     *
     * @param event The ActionEvent triggered by clicking the button.
     */
    public void btnTheaterAdd(ActionEvent event) {
        int capacity = getTheaterInputCapacity();
        cinema.addTheater(capacity);
        updateTheaterListView();
    }

    /**
     * Handles the action when the edit theater button is clicked.
     *
     * @param event The ActionEvent triggered by clicking the button.
     */
    @FXML
    public void btnTheaterEdit(ActionEvent event) {
        int theaterId = listTheaters.getSelectionModel().getSelectedItem().getId();
        int capacity = getTheaterInputCapacity();
        cinema.updateTheater(theaterId, capacity);
        updateTheaterListView();
    }

    /**
     * Handles the action when the delete theater button is clicked.
     *
     * @param event The ActionEvent triggered by clicking the button.
     */
    @FXML
    public void btnTheaterDelete(ActionEvent event) {
        int theaterId = listTheaters.getSelectionModel().getSelectedItem().getId();
        cinema.deleteTheater(theaterId);
        updateTheaterListView();
    }

    /**
     * Updates the ListView of sessions with the current list of sessions from the cinema.
     */
    public void updateSessionListView() {
        ObservableList<ISession> sessions = FXCollections.observableList(cinema.getSessions());
        listSessions.setItems(sessions);
    }

    /**
     * Gets the theater ID input for the session from the corresponding TextField.
     *
     * @return The theater ID entered by the user.
     */
    public int getSessionInputTheather() {
        return Integer.parseInt(textFieldTheaterID.getText());
    }

    /**
     * Gets the movie ID input for the session from the corresponding TextField.
     *
     * @return The movie ID entered by the user.
     */
    public int getSessionInputMovie() {
        return Integer.parseInt(textFieldMovieID.getText());
    }

    /**
     * Gets the session date input from the corresponding TextField.
     *
     * @return The session date entered by the user.
     */
    public Date getSessionInputDate() {
        String dateString = textFieldDate.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = dateFormat.parse(dateString);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Handles the action when the add session button is clicked.
     *
     * @param event The ActionEvent triggered by clicking the button.
     */
    public void btnSessionAdd(ActionEvent event) {
        int theater = getSessionInputTheather();
        int movie = getSessionInputMovie();
        Date date = getSessionInputDate();
        cinema.addSession(theater, movie, date);
        updateSessionListView();
    }

    /**
     * Handles the action when the edit session button is clicked.
     *
     * @param event The ActionEvent triggered by clicking the button.
     */
    @FXML
    public void btnSessionEdit(ActionEvent event) {
        int idSession = listSessions.getSelectionModel().getSelectedItem().getId();
        Date date = getSessionInputDate();
        cinema.updateSession(idSession, date);
        updateSessionListView();
    }

    /**
     * Handles the action when the delete session button is clicked.
     *
     * @param event The ActionEvent triggered by clicking the button.
     */
    @FXML
    public void btnSessionDelete(ActionEvent event) {
        int sessionId = listSessions.getSelectionModel().getSelectedItem().getId();
        cinema.deleteSession(sessionId);
        updateSessionListView();
    }

    /**
     * Updates the ListView of seats with the current list of sessions from the cinema.
     */
    public void updateSeatsListView() {
        ObservableList<ISession> sessions = listSessions.getItems();
        listSeats.setItems(sessions);
    }

    /**
     * Gets the session ID input for the seat reservation from the corresponding TextField.
     *
     * @return The session ID entered by the user.
     */
    public int getSeatInputIdSession() {
        return Integer.parseInt(textFieldIdSession.getText());
    }

    /**
     * Gets the seat number input for the seat reservation from the corresponding TextField.
     *
     * @return The seat number entered by the user.
     */
    public int getSeatInputSeatNumber() {
        return Integer.parseInt(textFieldSeatNumber.getText());
    }

    /**
     * Handles the action when the reserve seat button is clicked.
     *
     * @param event The ActionEvent triggered by clicking the button.
     */
    @FXML
    public void btnSeatReserve(ActionEvent event) {
        int s = getSeatInputIdSession();
        int n = getSeatInputSeatNumber();
        try {
            cinema.bookSeat(s, n);
        } catch (SeatAlreadyBookedException e) {
            e.printStackTrace();
        }
        updateSessionListView();
        updateSeatsListView();
    }
}
