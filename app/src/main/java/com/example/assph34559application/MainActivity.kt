package com.example.assph34559application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.assph34559application.navigation.GetLayoutHomeNavigation
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "boarding") {
        composable("boarding") { GetLayoutBoarding(navController) }
        composable("login") { GetLayoutLogin(navController) }
        composable("signup") { GetLayoutSignUp(navController) }
        composable("home") { GetLayoutHomeNavigation(navController) }
        composable("cart") { GetLayoutCart(navController) }
        composable(
            "detail/{item}",
            arguments = listOf(
                navArgument("item")
                {type = NavType.StringType}
            )
        ) {backStack->
            val itemJson = backStack.arguments?.getString("item")
            val itemType = object : TypeToken<Product>(){}.type
            val item:Product? = Gson().fromJson(itemJson,itemType)
            GetLayoutDetailProduct(navController,item)
        }
        composable("checkout") { GetLayoutCheckOut(navController) }
        composable("review") { GetLayoutReviewProduct(navController) }
        composable("order") { GetLayoutOrder(navController) }
        composable("address") { GetLayoutShoppingAddress(navController) }
        composable("payment") { GetLayoutPaymentMethod(navController) }
        composable("createAddress") { GetLayoutCreateShoppingAddress(navController) }
        composable("createPayment") { GetLayoutCreatePaymentMethod(navController) }
        composable("myReview") { GetLayoutMyReview(navController) }
        composable("setting") { GetLayoutSetting(navController) }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    AppNavigation()

}