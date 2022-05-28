package com.example.demo.controllers;

import com.example.demo.enitites.Client;
import com.example.demo.enitites.Reservation;
import com.example.demo.enitites.ReservationDTO;
import com.example.demo.enitites.Table;
import com.example.demo.services.ClientService;
import com.example.demo.services.ReservationService;
import com.example.demo.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    private ReservationService reservationService;
    private TableService tableService;
    private ClientService clientService;

    @Autowired
    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Autowired
    public void setTableService(TableService tableService) {
        this.tableService = tableService;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/order")
    public String save(@ModelAttribute ReservationDTO reservationDTO) {
        Long start = System.currentTimeMillis();
        Reservation reservation = new Reservation();
        Client client = clientService.getByName(reservationDTO.getCustomerName());
        Table table = tableService.getAll().get(0);
        reservation.setClient(client);
        reservation.setDate(reservationDTO.getTime());
        reservation.setTable(table);
        reservationService.save(reservation);
        Long stop = System.currentTimeMillis();

        System.out.println("Creating time is: " + (stop - start));
        return "index";
    }
}
