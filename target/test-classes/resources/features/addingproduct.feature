Feature: Adding product with exsisting credentials and checkout

@Addingproduct
Scenario: Adding product with exsisting credentials and checkout
Given once url is loaded then print the url 
Then verify the title of the site
And click on Sign In button
Then type 'test2323@gmail.com' in email address and Password as 'assdfds' 
Then click on login button 
Then Click on Women category
Then select T-shirts
Then enable  Large size size from size 
Then click on Casuals under Styles
Then Click on  Shortsleeve under Properties
Then click on Instock  under Avaialbility 
Then click on Quick View 
Then increase the quantity 
Then Change the size from dropdown 
Then change the colour  of tshirt to blue
Then click on Add to Cart
Then click on proceed to checkout to add product to cart
Then click on proceed to checkout from Cart summary page
Then click on proceed to checkout from  ADDRESSES page
Then click on agree terms and conditions 
Then click on proceed to checkout from  SHIPPING page
Then  select the payment method  Pay by Check
Then click on I confrim My order 
Then capture the reference code of the order.




