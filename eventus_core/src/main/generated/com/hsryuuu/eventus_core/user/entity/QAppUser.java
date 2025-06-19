package com.hsryuuu.eventus_core.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAppUser is a Querydsl query type for AppUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAppUser extends EntityPathBase<AppUser> {

    private static final long serialVersionUID = 1790027796L;

    public static final QAppUser appUser = new QAppUser("appUser");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final DateTimePath<java.time.LocalDateTime> lastModifiedAt = createDateTime("lastModifiedAt", java.time.LocalDateTime.class);

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final EnumPath<com.hsryuuu.eventus_core.user.UserRole> role = createEnum("role", com.hsryuuu.eventus_core.user.UserRole.class);

    public final StringPath username = createString("username");

    public QAppUser(String variable) {
        super(AppUser.class, forVariable(variable));
    }

    public QAppUser(Path<? extends AppUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAppUser(PathMetadata metadata) {
        super(AppUser.class, metadata);
    }

}

