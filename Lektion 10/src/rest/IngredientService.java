package rest;

import data.IngredientDAO;
import data.IngredientDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("ingredient")
public class IngredientService {

    @GET
    public String getIngredientList() {
        List<IngredientDTO> list = IngredientDAO.getInstance().getIngredientList();
        return new JSONArray(list).toString();
    }

    @GET
    @Path("{id}")
    public String getIngredient(@PathParam("id") int id) {
        String returnString;
        IngredientDTO ingredient = IngredientDAO.getInstance().getIngredient(id);
        if (ingredient == null)
            returnString = "Ingredient with ID " + id + " does not exist";
        else
            returnString = new JSONObject(ingredient).toString();

        return returnString;
    }

    @POST
    @Path("form")
    public String addIngredient(@FormParam("id") String id, @FormParam("name") String name, @FormParam("amount") String amount) {
        IngredientDTO ingredient = new IngredientDTO(Integer.parseInt(id), name, Double.parseDouble(amount));
        IngredientDAO.getInstance().addIngredient(ingredient);

        return "Ingredient added";
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String setIngredient(String body) {
        JSONObject jsonObject = new JSONObject(body);
        IngredientDTO ingredient = new IngredientDTO(jsonObject.getInt("id"), jsonObject.getString("name"), jsonObject.getDouble("amount"));
        IngredientDAO.getInstance().setIngredient(ingredient);

        return "Ingredient updated";
    }

    @DELETE
    @Path("{id}")
    public String deleteIngredient(@PathParam("id") int id) {
        IngredientDAO.getInstance().deleteIngredient(id);
        return "Ingredient deleted";
    }
}
