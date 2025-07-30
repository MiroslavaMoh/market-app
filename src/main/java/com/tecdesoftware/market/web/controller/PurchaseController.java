package com.tecdesoftware.market.web.controller;

import com.tecdesoftware.market.domain.Purchase;
import com.tecdesoftware.market.domain.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Le dice a Spring que va a ser el controlador de una API REST
@CrossOrigin(origins = "*")
@RestController
@RequestMapping
@Tag(name = "Purchase Controller", description = "Manage purchases and its item's list.")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    @Operation(
            summary = "Get all purchases",
            description = "Return a list of all purchasesand its items list iwth details."
    )
    @ApiResponse(responseCode = "200", description = "Successful retrieval of purchases.")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<>( purchaseService.getAll(), HttpStatus.OK);
    };

    @GetMapping("/client/{idClient}")
    @Operation(
            summary = "Get purchases by client id. You will need a a previously existant client Id.",
            description = "Return a product by its ID if it exists"
    )
    @ApiResponse(responseCode = "200", description = "Purchase with this client found")
    @ApiResponse(responseCode = "404", description = "Purchese with this client not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")

    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("idClient") String clientId){
        return purchaseService.getByClient(clientId).map(
                purchases -> new ResponseEntity<>(purchases, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    };

    @PostMapping("/save")
    @Operation(
            summary = "Save a new purchase",
            description = "Registers a new purchase and its item list and returns the created purchase",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Example Purchase",
                                    value = """                                            
                                            {
                                                    {
                                                                   "clientId": "CLI001",
                                                                   "date": "1992-08-10T17:30:00",
                                                                   "paymentMethod": "T",
                                                                   "comment": "",
                                                                   "state": "true",
                                                                   "items": [
                                                                     {
                                                                       "productId": 17,
                                                                       "quantity": 10,
                                                                       "total": 3000,
                                                                       "active": true
                                                                     },
                                                                     {
                                                                       "productId": 22,
                                                                       "quantity": 1,
                                                                       "total": 4000,
                                                                       "active": true
                                                                     },
                                                                     {
                                                                       "productId": 27,
                                                                       "quantity": 1,
                                                                       "total": 9000,
                                                                       "active": true
                                                                     },
                                                                     {
                                                                       "productId": 36,
                                                                       "quantity": 1,
                                                                       "total": 40000,
                                                                       "active": true
                                                                     },
                                                                     {
                                                                       "productId": 44,
                                                                       "quantity": 2,
                                                                       "total": 16400,
                                                                       "active": true
                                                                     }
                                                                   ]
                                                                 }
                            """
                            )
                    )
            )
    )
    @ApiResponse(responseCode = "201", description = "Purchase created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid purchase data")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "409", description = "Purchase conflict (duplicate code or SKU)")
    @ApiResponse(responseCode = "500", description = "Internal server error")

    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    };
}
