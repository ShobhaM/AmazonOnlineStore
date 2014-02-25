package com.rest.os.services;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.os.bean.*;
import com.rest.os.cart.CartItem;
//import com.rest.os.cart.CartItem;
import com.rest.os.cart.ShoppingCart;
import com.rest.os.dao.*;

@Path("/WebService")
public class Service {
	UserLoginAuthentication userLogin = new UserLoginAuthentication();
	ProductUtil prodUtilObj = new ProductUtil();
	ShoppingCart scart = new ShoppingCart();

	@POST
	@Path("/SignUp")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response signUp(User user) {
		System.out.println("inside post in service");
		String output = userLogin.registerUser(user);
		return Response.status(200).entity(output).build();

	}

	@POST
	@Path("/SignIn")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response signIn(User user) {
		String result = userLogin.signInUser(user);
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/ProductList")
	@Produces(MediaType.APPLICATION_JSON)
	public Product[] getProdList() {

		System.out.println(" inside getprodlist...");
		Product[] pArray = prodUtilObj.getProductList();

		return pArray;

	}
	
		//add a specific item to the cart	
	@POST
	@Path("/ShoppingCart/{cartId}/item")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getCartItem(CartItem item) throws IOException {

		System.out.println(" inside addCartItem method...");
		String output  = scart.addCartItem(item);

		return Response.status(200).entity(output).build();

	}
	
	//remove a specific item from the cart
			@DELETE
			@Path("/ShoppingCart/{cartId}/cartItems/{prodId}")
			public Response removeCartItem(@PathParam("cartId") int cartId,
					@PathParam("prodId") int prodId) {

				System.out.println(" inside removeCartItem method...");
				String output  = scart.removeCartItem(cartId,prodId);

				return Response.status(200).entity(output).build();

			}

	public static void main(String[] args) {
		
		Service testService = new Service();
		Product[] myProdArray = testService.getProdList();
		for(Product prod: myProdArray){
			System.out.println(prod);
		}
		

	}

}
