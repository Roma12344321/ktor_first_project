package com.martynov.ktor.di

import com.martynov.ktor.models.Person
import com.martynov.ktor.models.Post
import com.typesafe.config.ConfigFactory
import dagger.Module
import dagger.Provides
import org.hibernate.SessionFactory
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.Configuration
import javax.inject.Singleton


@Module
class HibernateModule {

    @Singleton
    @Provides
    fun provideSessionFactory() : SessionFactory {
        val config = ConfigFactory.load()
        val configuration = Configuration().apply {
            setProperty("hibernate.connection.driver_class", config.getString("database.driver"))
            setProperty("hibernate.connection.url", config.getString("database.url"))
            setProperty("hibernate.connection.username", config.getString("database.user"))
            setProperty("hibernate.connection.password", config.getString("database.password"))
            setProperty("hibernate.dialect", config.getString("database.dialect"))
            setProperty("hibernate.show_sql", config.getString("database.show_sql"))
            setProperty("hibernate.hbm2ddl.auto", config.getString("database.hbm2ddl_auto"))
            setProperty("hibernate.hikari.minimumIdle", config.getString("database.hikari.minimumIdle"))
            setProperty("hibernate.hikari.maximumPoolSize", config.getString("database.hikari.maximumPoolSize"))
            setProperty("hibernate.hikari.idleTimeout", config.getString("database.hikari.idleTimeout"))
            addAnnotatedClass(Person::class.java)
            addAnnotatedClass(Post::class.java)
            // HERE YOUR ANNOTATED CLASSES
        }
        val serviceRegistry = StandardServiceRegistryBuilder()
            .applySettings(configuration.properties)
            .build()
        return configuration.buildSessionFactory(serviceRegistry)
    }
}