import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Login from './pages/Login';
import Signup from './pages/Signup';
import Booking from './pages/Booking';
import ForgotPassword from './pages/ForgotPassword';
import ResetPassword from './pages/ResetPassword';
import MapView from './components/MapView';
import Payment from './pages/Payment';
import BusBooking from './pages/BusBooking';
import TrainBooking from './pages/TrainBooking';
import FlightBooking from './pages/FlightBooking';
import BookingChoice from './pages/BookingChoice';
import AIChat from './components/AIChat'; 
import Menu from './components/Menu'; 
import AboutUs from './pages/AboutUs'; // Assuming you have an AboutUs page


const App = () => {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/login" element={<Login />} />
      <Route path="/signup" element={<Signup />} />
      <Route path="/booking" element={<Booking />} />
      <Route path="/forgot-password" element={<ForgotPassword />} />
      <Route path="/reset-password" element={<ResetPassword />} />
      <Route path="/map" element={<MapView />} />
      <Route path="/Payment" element={<Payment />} />
      <Route path="/bus-booking" element={<BusBooking />} />
      <Route path="/train-booking" element={<TrainBooking />} />
      <Route path="/flight-booking" element={<FlightBooking />} />
      <Route path="/book-choice" element={<BookingChoice />} />
      <Route path="/menu" element={<Menu />} />
      <Route path="/aichat" element={<AIChat />} />
      <Route path="/about-us" element={<AboutUs />} />
      {/* Add more routes as needed */}
    </Routes>
  );
};

export default App;