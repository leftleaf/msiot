namespace java com.example.thrift.user

struct UserInfo {
    1:i32 id,
    2:string username,
    3:string password,
    4:string realName,
    5:string email,
    6:string mobile,
    7:string apiKey
}

service UserService {

    // find user info
    UserInfo getUserById(1:i32 id);
    UserInfo getUserByName(1:string name);

    // update user info
    void updateUserInfo(1:UserInfo userInfo);

    // add user or register
    void registerUser(1:UserInfo userInfo);

}