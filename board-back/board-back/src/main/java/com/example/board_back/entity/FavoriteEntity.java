package com.example.board_back.entity;

import com.example.board_back.entity.primaryKey.FavoritePk;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "favorite")
@Table(name = "favorite")
@IdClass(FavoritePk.class) // pk가 2개 이상일 때, 복합키로 설정
public class FavoriteEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userEmail;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNumber;

}
