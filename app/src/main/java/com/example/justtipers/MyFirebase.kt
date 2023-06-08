import com.google.firebase.database.*

class MyFirebase {
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val usersRef: DatabaseReference = database.getReference("users")

    fun registerUser(name: String, username: String, onDataRegistered: (userId: String) -> Unit) {
        val userId = usersRef.push().key // Generate unique key for new user
        val userRef = usersRef.child(userId ?: "")

        val userData = HashMap<String, Any>()
        userData["name"] = name
        userData["username"] = username

        userRef.setValue(userData)
            .addOnSuccessListener {
                onDataRegistered(userId ?: "")
            }
            .addOnFailureListener {
                // Handle the failure
            }
    }

    fun getUserData(userId: String, onDataLoaded: (name: String, username: String) -> Unit) {
        val userRef = usersRef.child(userId)

        userRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val userData = snapshot.value as? Map<String, Any>
                val name = userData?.get("name") as? String ?: ""
                val username = userData?.get("username") as? String ?: ""

                onDataLoaded(name, username)
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle the error
            }
        })
    }

    companion object {
        fun saveUserData(
            name: String,
            username: String,
            email: String,
            password: String,
            profileImageUriString: String
        ) {
            // Implement saving user data to the database
        }
    }
}
