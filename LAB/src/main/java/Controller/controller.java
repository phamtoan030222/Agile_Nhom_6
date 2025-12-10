package com.example.demo.controller;

import com.example.demo.entity.Booking;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // GET tất cả booking
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // GET phân trang booking
    @GetMapping("/page")
    public Page<Booking> getBookingsPage(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "5") int size) {
        return bookingService.getBookingsPage(page, size);
    }

    // GET detail booking theo mã
    @GetMapping("/{bookingCode}")
    public Booking getBookingDetail(@PathVariable String bookingCode) {
        return bookingService.getBookingByCode(bookingCode);
    }

    // POST tạo booking mới
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    // DELETE booking theo mã
    @DeleteMapping("/{bookingCode}")
    public String deleteBooking(@PathVariable String bookingCode) {
        bookingService.deleteBooking(bookingCode);
        return "Deleted booking with code: " + bookingCode;
    }
}
