package com.coinker.grpc.server.service;

import com.coinker.grpc.server.annotation.GrpcService;
import com.example.grpc.UserRequest;
import com.example.grpc.UserResponse;
import com.example.grpc.UserServiceGrpc;
import io.grpc.stub.StreamObserver;



@GrpcService
public class UserService extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void query(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        System.out.println(" UserService 接收到的参数，name：" + request.getName());

        UserResponse response = UserResponse.newBuilder().setName("微观技术").setAge(30).setAddress("上海").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
