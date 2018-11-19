-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 19, 2018 at 11:16 AM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 5.6.36

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tims`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer_master`
--

CREATE TABLE `customer_master` (
  `id` int(11) NOT NULL,
  `salutation` varchar(25) DEFAULT NULL,
  `firstname` varchar(70) DEFAULT NULL,
  `lastname` varchar(70) DEFAULT NULL,
  `contactno` varchar(45) DEFAULT NULL,
  `alternatecontact` varchar(45) DEFAULT NULL,
  `emailid` varchar(45) DEFAULT NULL,
  `alternateemail` varchar(45) DEFAULT NULL,
  `faxno` varchar(45) DEFAULT NULL,
  `billstreetno` varchar(75) DEFAULT NULL,
  `billstreetname` varchar(75) DEFAULT NULL,
  `billcity` varchar(45) DEFAULT NULL,
  `billpostalcode` varchar(45) DEFAULT NULL,
  `billstate` varchar(45) DEFAULT NULL,
  `billcountry` varchar(45) DEFAULT NULL,
  `shipstreetno` varchar(75) DEFAULT NULL,
  `shipstreetname` varchar(75) DEFAULT NULL,
  `shipcity` varchar(45) DEFAULT NULL,
  `shippostalcode` varchar(45) DEFAULT NULL,
  `shipstate` varchar(45) DEFAULT NULL,
  `shipcountry` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_master`
--

INSERT INTO `customer_master` (`id`, `salutation`, `firstname`, `lastname`, `contactno`, `alternatecontact`, `emailid`, `alternateemail`, `faxno`, `billstreetno`, `billstreetname`, `billcity`, `billpostalcode`, `billstate`, `billcountry`, `shipstreetno`, `shipstreetname`, `shipcity`, `shippostalcode`, `shipstate`, `shipcountry`) VALUES
(1, 'Mr.', 'Santosh', 'Labade', '7745002244', '7745002255', 'santosh.labade@tejovat.com', NULL, '12345678963', '304, 42/1 Whitesquare', 'Hinjewadi road Wakad', 'Pune', '411057', 'Maharashtra', 'India', '304, 42/1 Whitesquare', 'Hinjewadi road Wakad', 'Pune', '411057', 'Maharashtra', 'India'),
(2, 'Mr.', 'Yogesh ', 'Lokare ', '12345678', '963258741', 'yogesh.lokare@tejovat.com', '', '120-963-9999', 'At post Wadgaon nali, bhoom-jamkhed road', 'Taluka bhoom ', 'Osmanabad', '411015', 'Maharashtra', 'India', 'At post Wadgaon nali, bhoom-jamkhed road', 'Taluka bhoom ', 'Osmanabad', '411015', 'Maharashtra', 'India'),
(3, 'Miss', 'Vishakha ', 'Patil', '7218030984', '9632587415', 'vishkha.patil@tejovat.com', '', '4564645464', 'Plot No 1B, J J Chambers Koyananagar', 'Chinchwad Pune', 'Pune', '411052', 'Alabama', 'USA', 'Plot No 1B, J J Chambers Koyananagar', 'Chinchwad Pune', 'Pune', '411052', 'Alabama', 'USA');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `id` int(11) NOT NULL,
  `invoiceno` varchar(45) DEFAULT NULL,
  `invoicedate` date DEFAULT NULL,
  `duedate` date DEFAULT NULL,
  `terms` varchar(150) DEFAULT NULL,
  `salesperson` varchar(75) DEFAULT NULL,
  `salesorderno` varchar(45) DEFAULT NULL,
  `customerid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `package_items`
--

CREATE TABLE `package_items` (
  `id` int(11) NOT NULL,
  `itemid` int(11) DEFAULT NULL,
  `qtyordered` int(5) DEFAULT NULL,
  `qtypacked` int(5) DEFAULT NULL,
  `qtytopack` int(5) DEFAULT NULL,
  `packageid` int(11) DEFAULT NULL,
  `productname` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `package_items`
--

INSERT INTO `package_items` (`id`, `itemid`, `qtyordered`, `qtypacked`, `qtytopack`, `packageid`, `productname`) VALUES
(3, 1, 1, 0, 1, 6, 'Smart Wi-Fi Video Doorbell DP1000 ');

-- --------------------------------------------------------

--
-- Table structure for table `package_order`
--

CREATE TABLE `package_order` (
  `id` int(11) NOT NULL,
  `packageno` varchar(45) DEFAULT NULL,
  `packagedate` date DEFAULT NULL,
  `packagenotes` varchar(150) DEFAULT '-',
  `totalqty` int(5) DEFAULT '0',
  `shipmentno` varchar(45) DEFAULT NULL,
  `shipdate` date DEFAULT NULL,
  `carrier` varchar(45) DEFAULT '-',
  `tracking` varchar(45) DEFAULT '-',
  `shipnotes` varchar(150) DEFAULT '-',
  `delivered` char(1) DEFAULT 'N',
  `salesorderno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `package_order`
--

INSERT INTO `package_order` (`id`, `packageno`, `packagedate`, `packagenotes`, `totalqty`, `shipmentno`, `shipdate`, `carrier`, `tracking`, `shipnotes`, `delivered`, `salesorderno`) VALUES
(5, 'PKG-1001', '2018-08-18', 'Notes', 0, NULL, NULL, NULL, NULL, NULL, 'N', 15),
(6, 'PKG-1002', '2018-08-18', 'Packing Notes', 0, NULL, NULL, NULL, NULL, NULL, 'N', 15);

-- --------------------------------------------------------

--
-- Table structure for table `productitems`
--

CREATE TABLE `productitems` (
  `id` int(11) NOT NULL,
  `serial_no` varchar(45) DEFAULT NULL,
  `item_code` varchar(45) DEFAULT NULL,
  `barcode` varchar(45) DEFAULT NULL,
  `productid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productitems`
--

INSERT INTO `productitems` (`id`, `serial_no`, `item_code`, `barcode`, `productid`) VALUES
(1, 'TJSHDP10011', 'TJSHDP1000', 'TJSHDP10011', 1),
(3, 'TJSHDP10013', 'TJSHDP1000', 'TJSHDP10013', 1),
(4, 'TJCH1000', 'THCH1000', 'TJCH1000', 2),
(5, 'SKY1000', 'SKY400', 'SKY1000', 3);

-- --------------------------------------------------------

--
-- Table structure for table `productmaster`
--

CREATE TABLE `productmaster` (
  `id` int(11) NOT NULL,
  `product_code` varchar(45) DEFAULT NULL,
  `product_name` varchar(70) DEFAULT NULL,
  `product_description` longtext,
  `unit` varchar(45) DEFAULT NULL,
  `manufacturer` varchar(70) DEFAULT NULL,
  `brand` varchar(70) DEFAULT NULL,
  `selling_price` double(10,2) DEFAULT NULL,
  `purchase_price` double(10,2) DEFAULT NULL,
  `opening_stock` int(11) DEFAULT NULL,
  `reorder_level` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productmaster`
--

INSERT INTO `productmaster` (`id`, `product_code`, `product_name`, `product_description`, `unit`, `manufacturer`, `brand`, `selling_price`, `purchase_price`, `opening_stock`, `reorder_level`) VALUES
(1, 'TJ-SH-DP1000 ', 'Smart Wi-Fi Video Doorbell DP1000 ', 'You can see your visitors, communicate with them and unlock the door through smartphone or tablet from anywhere in the world....', 'Box', 'Tejovat Technology Pvt. Ltd', 'Tejovat', 9000.50, 7000.00, 0, '08'),
(2, 'TJ-CHATSIM', 'Chatsim', 'This is chatsim card for traveller', 'EACH', 'Chatsim', 'Chatsim', 2000.00, 1500.00, 10, '10'),
(3, 'TJ-SH-DP400', 'Sky bell', 'This is sky bell', '50', 'Skybell', 'Skybell', 7000.00, 5000.00, 10, '10');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `role` varchar(50) DEFAULT NULL,
  `description` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `role`, `description`) VALUES
(1, 'Admin', 'This is Admin'),
(2, 'User', 'This is user'),
(3, 'Manager', 'This is manager\n');

-- --------------------------------------------------------

--
-- Table structure for table `sales_items`
--

CREATE TABLE `sales_items` (
  `id` int(11) NOT NULL,
  `productid` int(11) DEFAULT NULL,
  `itemid` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `rate` double(10,2) DEFAULT NULL,
  `discount` varchar(45) DEFAULT NULL,
  `amount` double(10,2) DEFAULT NULL,
  `salesorderid` int(11) DEFAULT NULL,
  `productname` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales_items`
--

INSERT INTO `sales_items` (`id`, `productid`, `itemid`, `quantity`, `rate`, `discount`, `amount`, `salesorderid`, `productname`) VALUES
(18, 1, 1, 1, 9000.50, '0.0', 9000.50, 15, 'Smart Wi-Fi Video Doorbell DP1000 '),
(37, 1, 1, 1, 9000.50, '0.0', 9000.50, 16, 'Smart Wi-Fi Video Doorbell DP1000 '),
(38, 1, 1, 1, 9000.50, '0.0', 9000.50, 16, 'Smart Wi-Fi Video Doorbell DP1000 '),
(41, 1, 1, 1, 9000.50, '10.0', 8100.45, 17, 'Smart Wi-Fi Video Doorbell DP1000 '),
(42, 1, 3, 1, 9000.50, '5.0', 8550.48, 17, 'Smart Wi-Fi Video Doorbell DP1000 '),
(43, 3, 5, 1, 7000.00, '0.0', 7000.00, 18, 'Sky bell');

-- --------------------------------------------------------

--
-- Table structure for table `sales_order`
--

CREATE TABLE `sales_order` (
  `id` int(11) NOT NULL,
  `salesorderno` varchar(70) DEFAULT NULL,
  `reference` varchar(70) DEFAULT NULL,
  `orderdate` date DEFAULT NULL,
  `expecteddate` date DEFAULT NULL,
  `salesperson` varchar(75) DEFAULT NULL,
  `shipvia` varchar(45) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `subtotal` double(10,2) DEFAULT NULL,
  `tax` double(8,2) DEFAULT NULL,
  `total` double(10,2) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `terms` varchar(255) DEFAULT NULL,
  `packaged` varchar(70) DEFAULT NULL,
  `shiped` varchar(70) DEFAULT NULL,
  `invoiceno` varchar(70) DEFAULT NULL,
  `customerid` int(11) DEFAULT NULL,
  `filename` varchar(100) DEFAULT NULL,
  `filetype` varchar(100) DEFAULT NULL,
  `filedata` longblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales_order`
--

INSERT INTO `sales_order` (`id`, `salesorderno`, `reference`, `orderdate`, `expecteddate`, `salesperson`, `shipvia`, `status`, `subtotal`, `tax`, `total`, `notes`, `terms`, `packaged`, `shiped`, `invoiceno`, `customerid`, `filename`, `filetype`, `filedata`) VALUES
(14, 'SO-1001', '10001', '2018-08-18', '2018-08-18', 'Yogesh Lokare', 'DTC', 'CONFIRMED', 9000.50, 0.00, 9000.50, 'Note', '', NULL, NULL, 'INV-1004', 1, NULL, NULL, NULL),
(15, 'SO-1002', '1500', '2018-08-18', '2018-08-18', 'Yogesh', 'DTC', 'CONFIRMED', 9000.50, 0.00, 9000.50, 'Notes', '', NULL, NULL, 'INV-1005', 2, NULL, NULL, NULL),
(16, 'SO-1003', '45632', '2018-08-18', '2018-08-18', 'Yogesh Lokare', 'DTC', 'CONFIRMED', 18001.00, 1800.10, 19801.10, 'NOTES', '', NULL, NULL, 'INV-1006', 1, NULL, NULL, NULL),
(17, 'SO-1004', '123456', '2018-08-25', '2018-08-25', 'Yogesh Lokare ', 'Courier', 'CONFIRMED', 16650.93, 1665.09, 18316.02, 'Test Notes', '', NULL, NULL, 'INV-1003', 1, NULL, NULL, NULL),
(18, 'SO-1005', '963258', '2018-10-27', '2018-10-27', 'Hello', 'ggg', 'CONFIRMED', 7000.00, 0.00, 7000.00, 'ggg', '', NULL, NULL, 'undefined', 3, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `useremail` varchar(50) DEFAULT NULL,
  `username` varchar(70) DEFAULT NULL,
  `userage` int(20) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `userpwd` varchar(50) DEFAULT NULL,
  `streetno` varchar(50) DEFAULT NULL,
  `streetname` varchar(50) DEFAULT NULL,
  `postalcode` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `userenabled` tinyint(4) DEFAULT NULL,
  `confirmationtoken` varchar(45) DEFAULT NULL,
  `resettoken` varchar(45) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `lastlogin` datetime DEFAULT NULL,
  `contactno` varchar(50) DEFAULT NULL,
  `filename` varchar(100) DEFAULT NULL,
  `filetype` varchar(100) DEFAULT NULL,
  `picture` longblob,
  `tempactive` tinyint(4) DEFAULT NULL,
  `userrole` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `firstname`, `lastname`, `useremail`, `username`, `userage`, `gender`, `userpwd`, `streetno`, `streetname`, `postalcode`, `city`, `province`, `country`, `userenabled`, `confirmationtoken`, `resettoken`, `createdon`, `lastlogin`, `contactno`, `filename`, `filetype`, `picture`, `tempactive`, `userrole`) VALUES
(2, 'Ajay', 'Katware', 'ajay.katware@tejovat.com', 'ajay.katware@tejovat.com', NULL, 'M', '12345678', 'Uni 150', 'Nigdi Road', '412114', 'Pune', 'Madhya Pradesh', 'India', NULL, NULL, NULL, NULL, NULL, '9923566106', NULL, NULL, NULL, NULL, 1),
(3, 'Yogesh', 'Lokare', 'yogeshlokare12@gmail.com', 'yogesh.lokare@tejovat.com', NULL, 'M', '87654321', 'Unit 16', 'Wadgaon', '413504', 'Bhoom', 'Maharashtra', 'India', NULL, NULL, '-', NULL, NULL, '545454545', 'yogesh.jpg', 'image/jpeg', 0xffd8ffe000104a46494600010100000100010000ffe100d445786966000049492a0008000000020031010200070000002600000069870400010000002e00000000000000476f6f676c650000020000900700040000003032323086920700800000004c000000000000000000000000000000202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202020202000ffdb0084000302020808080808080808080a0808080808080a080808080808080808080808080808080808080808080808080a080808080a090a08080d0d0a080d08080908010304040605060a06060a0d0e0b0e100f100f0f0f0f0d0e0f0d0f0f0d100f100e0f0f0d0f0f0d0f0d0f0d0f0f0d0d0d0d0d0d0e0d0d0e0d0d0f0d0d0d0f0d0d0dffc0001108008c008b03011100021101031101ffc4001d000001040301010000000000000000000003040506070102080009ffc4004010000201030204040305050605050000000102030004111221050613310722415114617108233281a1244252629109153372c1f025346382d1183565b1e1ffc4001c0100010501010100000000000000000000010002030405060708ffc4003f1100010301050506040405020701000000010002110304122131410551617181132291b1c1f00632a1d14252c2f114627282b292e12353637383a2b315ffda000c03010002110311003f00b961b7af5c2579f00974505464a78095c50d32714529486814e08eb1d3494211162a6ca742dc474d28adb4529497b4504960a51082d36f71b77de94a4021903e5441d125ab434e94d8407828842126961a78285d4925829d2824334152029b0921b7a901493dc30d404a784b228a98514ae38e9b308a32474d94e4654a694a16e169a8ac3b81dc81f538a05d19a280388212543a9652415041208009c81b8c0233ed91ef42f0460aa47c57fb60f0be18cd0c7aafa700e63859444ac3f7649cea507dc46b2b0f502ae762d6006bb8301c408971e4d91d2f16ce8acd2b33ea62060a86e3ff006fee24e18dbd95a40bb0d4c65b831939035366107271bf4b48ce37ce6abd5b458e9825b7dd1bcb5bff00a80e3e0ee32215f6d83f312ab0e61fb4c71a727f6b983c6ceac80c7e41829e5e9c71ea1df4ea380403e6d43192fda0e3de6b5919e01d8eb3de73bf6dd8cde6d8a965083078c17988e5375290548eb2911cc2400b619cb29977dfcc1c0c6950723319b7b8e394687118f8c6ec08de6347ff000cdc442e9bf053ed4534a21b6bf085c82165072cf8fc01f719760321b4ee31f89986ad0b2d66d6044804786994f131138624dd6831936ab1dcef3725d3e986008ec4023e86ac872c9842921a912292c90d38194c21239a1a7ca6c24661a29a9de28ea3254895c71d3094e4a1569a4a722aad3520b7028229171ce29d189e5d0f26819d08353b12400141206493dc9006e4900134e68930881261702f8e9e3dc9271a75d45ada14d76d6f2a858c5c8833a2e237f2663b9dcebd4bf74a412349aaefb51a5585369820660e338ea37b4f49df2b7e859e294ea75e13f65cfe7c68bc6590199834a089240009595b72824d9d236fde442a18139cec073adb6d56030e3899cfde3b8ad53499230c936c5c799d46a3b67763bb3761dc9ec0761e84fc8566b6a4bc89c559bb84e88bc462d23abaf46ac7931b90b80b9032a73f91eff3cc9da09d67dfbc54777043b5e67fbc591147940073862c546e300777c64e5719fa62985fa1f7ef2e4881b929bee76760eba5511df5b2695751ab2760477dff0011391db23b53a493338f84a6a6a4e60646d4a4ab29d48ca76f53b0eddf7c76dbb55aa55cb1c0b4fdd31cd0702be9ff00d947c4f7e2bc1a09a51f7b096b691b180fd23a51c636c94d21b0079813eb5d251ac2ab6f0187918c478e5c0819ae5ad74bb3a840e6ae074ab40aa093cb1d3c149239a2a9014c8490c352028270892a094e4a5169853c23a2d351445a05259a00a2b0e808208c83b11ee0f7a492e23fb6bf8412246b7e163957abd36091f4da38d97112385ceb0a5480f9075498d3800ae75be8f6ad1506633c7deb8f0deb7b675718d32a98e53fb324cf8791570ca186e02827dfd7f4af22b7fc43498e2c6bb1063de8bd5ec1f0ed47b45470cc265e7ff071ed466221b248c2fa15241fd7f4c7bd4b62daada98aaf6ed90ea5800aafe2b1bab00e08db1faee467b64fd7fd2ba6a3583fe55cad6a2ea661c9b950649c9dbe58fd739ab4aa1439e63ef4f9c50843d7f3a49cbbc3fb34388b9878bc25bc892d948ab9ecf225c23b01fccb14609f5d23dab77673e441e3e87cc9f1587b4db830f3f45daa456ccac14274a74a0934a94f050498c74f94d84a2314c4e011d2989f08eb4125b8a08af53525ea08281f8ddc045c70db84235285d720f283d3507538d440cc40f5bbe7eefca19b00c35df768d476e6b8f38131d7257ec0d9b4d36939b80f12aa7b68e08d55ba994000033b9c0ed8ed9af922a9351e4c62beb5a5dc6068c90268ed6f3221b5d2c363213b12463b76dfd7d4fbd5d654a94801975542ab18e712e783c2173678b3e0a1cc8d1823049ef903ff00a3a7e78aed766ed80203971db4f63178bcce8a80e37cad341f8d763b641c83f2aeda85be956c1a715c2da6c15acff38c133744d5dbe37acf85ae29c0ca4bbcbfb34383110717b8df0f35a4007a6618e6909fafed03f4addd9c0c1f79fecb0b69bbe41cfd176ad6d9584b56a410419169c0a108056a494d8594a6e69c1190504f08cb4d496f42515ea12942f628230a83f13f98eee7b9e2dc344770ea2ded9ed9a2f2c6892c4a648e6d0c2499e7984a8b80ea8837553866a3b4ad828536d26b1a4b9a6f482499739b84cb40007038e674dbd9f666ba2ade8839f10b95adfc27e27716771c4ccaf15b41322476923c85ae181d33375350e9450920bea27f0cb9081016f2d75aac14ed6da7d932f1c2630074107327edbcaf4d165b7becae776af818c6a5a33386386835829a2e3885e43a91238bceb901103b6ffc0f189096f50c8739c7ad5afe3db5a09c07281c8830237caa86c35a8c869249e249e90ae4fb30f8ac9c2f854c38e5bcb7464bd79225923b5bd631c9040a2391ae256921d0f0c8fd26d382e491924517ed2b0b1f729b448fcad8eb901c277045bb2b69d46079a85a37b9eef4959f113ed25c1a68d85bf29f0d980c90678ad62391ea121b593b0ffa83d6add9b6c5165404b489c326faca65a363da8d337abb9d1a0bc47d4fa2a52e78cd94e1ae25e11c2ed4043d38208644567cf94ccdd4d2554125b4c6a4e91bed59fb4b6e3eabbb3b3b1a34bd0d98de21a04ee99c55fd93b0a95302ada5ce3add9cf703ac6f42e60f09e6e23d310436cb2ca88f6c618a2b785b274f4331054c3618217dc385c90198d676c5b613696d075490e25a6f126e9d09ccc68601ce6305b3f10ecfa7fc21b4b698696c117466d9ff007c174e7f675f2f491708bb95f204fc4240887b810430c4e48f43d40e847fd3af59b153730398f1041208dc41208c30c0eec17886d2702f681bbcd75562b4d642c1a412426a329211a720b45a7241190d30a7a32d09496f41159c5284217a914534717e030b6b95a243274caebc61d9543154661866505890ad90351c0dcd2755731a60e0278c729c8f2535224b8341c091e6b983997ed1b636d0c3c35ac27e9c2af831c91468e64046a6424020636d07719f53b7cca2cd5ad94c38c664c9249278e0725f5187d2b25573af41c045d10d034188cf3c9477c35e3ee2dfad1c862b6ea4890c6d182574e180209188f2c428df4e362010051b5d3ecdc1951b2e024c18fbe2af537b2b4be9b85d27091c1573cf9c6a396463a406c9d4cbbabefb36e73efdf71db35a764258d819693a7059d6a01eef38c8a88cae421555c67bb1ee7ff03e55649bee0e768997035900295720f87927100b1050218a449679b3a5d156390688c90575beac61fca06e738c352b4db3f87976a4100684c8c4f2e1c94d42cc1ef1c231e8a1be3873aa431c5676923791d6469919810207768b43858ceaeb1698ba2a80550293a751e93e1eb238bcda2a6790ea3ed82e7be2bb6b594d963a473c4f43978f92efdfb2e7244bc3f80d85b4e089424b34a0ee43dc4f2cf827b9204801cef906bda6ca08a72ecce3e3ebbd7815b1e1f5496e580f010ad5c55c54560d20921b51d524334e49050d38a211d29851455a08a253525ecd14966822bd8a092e1cf127c3764e2d73f7b616b1c32698cdcea7263645951c4411b5284758fccc012bdb6cd7925be9b6cb51d670200712230804cf862bdcf63936da22d2f24bae8d0192046a4019205bde5cb2b877b39ad91742bc08d11cf7cf47a6230a77395727b6c7735c5db29d199638dee3f7cd75941d51b8168bbc1422df82aca188040d47493b9c0ff43fa5547d434cc70565adbe2533f32e84f2e77ab36705d8a654780a3c9c7674578e29a48d24ff001155caabe36f30077db6fa5680a14dc439ed048ca745585a2a3010c300a5de1b78157bc6788c2618c3c16ef666edcba26885a662f80c72c59124c690db8dfb8aef761d1ed185a06449fb2f30f886b8a7543dc7310398fdc2fa946bd0c05e5ebc68a2b04d390427a2905a668c218202538a40a3a1a694f08a2804514534e092f6281292cd2497a8149739fda6ac6c12ead67bdb659849114566d413546c495f2e32da594e1b3b01f3af30f8ba9d66d5a75696008209e47ec57ac7c1b5693a8d4a554e21d207023ca42a2b9ebc47b358cadbae9041f2ae401fe51d87e79af3ab3592b547778752bd2ebdaa95261833c956b7bcefab023caae06c7639c6fb7d7d6b4bf81ba7bcaa32d61e304c771c419ce7b9356594c30289ee2e448e0c2ef4264a18b4297f85df685bae06d37c2dbc3706e8c31b2ca6418e9190ae8e9b03a9ba8cbbe40d8e0e307d33e1aa9484b1cd249ca081e60cf0cb9af31f88acfda383898027dfd17d12e41e6f5beb58ae02846745ea47ab574a42a19933819182195881a9594e06715db57a2ea2f2c3d0ef139fa1e20af3ae4a404540125ab53924273442108469c842029a72411d0d3539194d31145534925bd3125ea48af524122e2fc121b8431cf0c53a13929246b2264763a5c1191e8719151be9b6a0baf008e2a6a751f4dd798e20ef06150df691b4e0bc1b86cb75fdd3c3e59e4fb9b68deda22ad2b0fc6fb674443ce74e0938008cea0eb3eccb210eab569b6e3049c07789c9a371275d0027457e9dbad6f78636abe4f1380d4ae1ce0f6a8ea8c762c8ac46e0648dc0efd8e76af1cda4c346ab83461263870e8bd9b665515a9b49f9a314f51f0c03b0ac2bf39ade2d5bdcdae06f4e6bb728dc3056a722f8370da5a7c6f128cfc4dd624b28096125ad92361eedd01189ee9888add24074a80c7fc6213d7fe11d9d51cf16b708680436757119f268c7e99c2f29f88adac71ec198e389f4f7feeaf2f0c38add584ec2e2178a191524bb2e1912d55f425b2a96f2a8850f9cb1184ca9f34073ea15ececb6520ea441763700209700093c4971cb8c1c9cbcf9e4d330e9f7e8afcb3e211c83546e920fe246571fd54915cad4a552918a8d20f10479a41c0e45109a6a284c6884a10c8a49929321a91108e8d4cc93823a1a6a28a0d22125b834125914c28af529496452292e53fb7472d4f3c4842314863568bd9e672d23007dd6155057bf9d7e78b2ea8d7590d269c6f171e42001ca4932b4ec6c2ca979da881e6b8b7926f35c6a0f704e3e609ce2bc8f69e2f277af50d9248681a853db5976c63ea7ff00dae31e315dcb316cab7fc1ce58e0c934775cc3c420b2810abc566eaf24d73df4bce91066b7b63fb8660bf1054e905158bf55b2b61d7ad76d0f6430fcb7886df23517a25a358c0e032cf8edb1b5dac0685032efc447e1e1fd5e5cf2eb9e46e19c2efee7e3a1beb1e28cf2bca1a3b8b76e9c708fd96da28164668c2052bdb23aaf9c0518f52ad69a8da5d886b98d80220ff719d673e30d5e63d9f7af1c4fb85ef1e786cc387c314a5916e7885ab5dc87569082e3abd3cc6c9e6710b00048a73718c8c55bd935832ad5ab4c02e6d37dce1dd89c41c8389cbf08515a1a0b5ad764489fb272b6e5cb68423c515b43a115a40b1940758564024f34e26008df5c81d8ee14236a0769d7aad2daaf73a4e12670e5f2c1e0040cb310bf85a6d8ba004a167c83b98c8c6d21550432ea5225d2913b3af982b2db8233873da9cda94cc6b3bbed89006f05dc940fb3cfbf63c9024bcc675797490ad9054c6c7b2cc8dbc6492006cb464ec24276ab5d94fcb8ebbe46f691f30df9119c42a6ea4464b64941dc1cf71f983823ea08208f422a23ddc0aad8a0235141191a814f0942b5312440d42539101a6ca0b70682308b1db9383b004e351385ce093ee4e0024e90d8c542faad6679fbe9e2a7a745cfc922e3dcc315b42d36912848de6691d9a3b70a8da082748773ab23488cabb023aa8065c59c3ed3545261824c618912267765c70ddbae9a2da2dbce0b943ff5972dedf4b6fc65214e14eb2a7dd5a1692da4014c5302acf31d2d812aa0760241807465af57d94ca262cdf38c6f38fcc3191f960e9ca55aa6f2e1dff05cfd79e0d496dc42e6dd0ab219da5b474f32cd6d292f03c4c3675287412a080e8ebb14603c9f6d5514abb838473c33fb15e8bb1e99a9483da6797beaac2b8f0f26e1f17c65dc4100c0b689f0cf2ca481968723cb1825f4ca5433f4d4abab329a1f0d5928ed4b59bd8d3a78bb713a372c4612ee023591a3b72d952c74031861efc3880333c0e303a9d155fcdfcbaf31696562f23c7d72a3274759d42c92c9de491d5849ab035024e36c57afd10eb6d6bb4c77648bc7330321b8038464301bd79cd56b6833bc7bc74f5593e15e932695f3a1b6b7538c1ea9019883b1075c0db83dcd6c59b67dc879240ba5c60f23e44ac936bd1599c13845c275a3ebcef1fc6450411196478b285cea58d98a2b6a58b2e172757cf7dd6510d663986438eb24638e67272ce7d7bc5be3efc5769c520b892dd832f471777d2293a7aabd695218f1fc184c039ca899b18c0cf06fa7d8d37b08ef4b29ff004dd6098e39f5016cb5d7c876913e27f64b8f19756504877e8f5548c10d3dccd80f8d86ae93269c762b1e3b566983de38364c8dcd608039022794ef56386bf74c7c479a22e9c60baab895acedc91a9ae65566eb46431d2d6c07902107630e31ae4cead9eabe8b9c1e3010e76972716c47e3c092783b82a95181c011fbf34c8f03b92d1a8d392a33672dc60a9d2cab3a2baca8ac0aa3866ca05dc9c9aea1b5d8c175ee703ac3d8d1fe97620ef1a19030859e5aed00eb3e8a628f58a56723a353514647a644a28caf4139154d084916ce4467119232c54119dc29c967001df4aab7caabd67398dbe3df0576cf46f1c521e39cc5a524963f2e6d1d940380ad2dcb59a81db216328a3fcb54ee87dd6e7de8e6036f79cad6608f0f5855f78e3652c9662ca15676305b865504b69211a4560b9c0696e0e73ea87f84d6fec3635b7ed0f21bf3413c77720dd342a85b5d25b4c70f7e2aaae15f66b94ce5ee2dc0845df11eaa3380d2c6b1c4fa14292e19b1a413a7077abb52df45bdca4ec4b5a018ca644e3cd46ca750c17643d14ab94f95e6e177ed6b0c325c5acb3dd1b773197645509290b2804060cf2236a235e852402c1eb8ddbdb0ecfb7eca0d6735959a043a408c23107369806343942e87676d7abb32a975305cc39b77f2dc47966a94fb4573435cdfb000b4708644407d8f4f7df1a9cb48ea3bf97d4018bff0d6c2160d9dd808be4193a177e238e30d75d1c804eda3b48daed46b1f970807468c873dfc4a72f0dbc37f8cbb10c88cc25e21696d3100e0436c8f1ca091f8148e98192372bed5d0d5bb61b21ec8805b4f0df79c675cc82099581da3ad35817653efecba8b973c24e1dd44b8f854f3dd5c5db2b3c8eb88544a8023315c64c8318db3f3ae66a5babf7a9df3f85ba0e1a70215e1429883746a9f2cbc29b051683e161fba59af5885d075f68c12b839668621dff7e9dffe95a7be7b47778819ce033cf9b94668533f84601579ce9c1950f45328a2d2da055566d9649d2e301b25b7d4ab93bf7ce6b59950bd9da3b39a8e275fca7e927aa601060700a5a8e90cb2141816f736f0a1d59d51da24871f9fc3c59f5dcfbd60b69de6863b1bccc7817b84feaf1568bb5e3e4aafe6db0861844972f22adac173396450e626b8672b28563f880f85977c7e15dc6707a0b3b5f58cb0097bc44fe2b8008e38b5e23593a4aa4f7006e9d079feea35c91cfaeb6900ebbc784c14d6e08393ab3a70351392c4019624e0671598f75373892c0ed24ea0603e99705316b86015fc8f5a0573a8c8d4d28a32bd3514657a08ad2faeb4a330c6460027b02c428cec76c91e86813044a9a9b6f3a124b297a92c5376789678e4c762924133c32edee49427b0c45d8bef05a89a61f48fca6e91c0870047be2b6288900eefb2c70eb3f888208c118758d4e464616f2edb27b6c195589ec34d522e2cbd746a4f8b1bfb29f09c7de2a46ae85af1d7196920703bf92579248ffa4650e3dc1fad3df21b4e99c8070ea0007ea144332edf0975c2fde20c6cdc42e541c7b98d4ffa76aa2e31247e56a9db8f89504e39c4e68ad09808576e80832c57a735c0f852e5c0270a63498ec7647f7cd6abc035379c7940323ce156061b2a8ee48fb3f33dec82e591e21c42d230c873d7e9c4c5d11c6caa8f7055f7cab23a8dd4b5695ab68f6140d2a7f35c32741789391d4c08e105434e91aa43dd80c705d07cb56e91adb84554559af260a07631c50b039f5394662c49273deb9dac0b8baf1ccb04efc4fdd5f6e0001c53970d21510ff0d9c84efeb25d343f9655c0cfb7bd47f33b9bbc99fec89c074f54b38add90b71b91a6d2d101f9b0b69491f9a9cd3e9e269f371fa91eaa33af4545f3973231bcbd50a580e2569650e3191f0c9a1f3d8e3508bd7b1f96fb94da59483b75193ff920fa10a2244ff77920f06e7c8e74631c8240f777f282189cc691c4109cfbf51ce3619a96d147b3aa48dcc1c88249f30981dddc78aa3396f99aff0088f12e211a169175cafd2931d06b281cdbb46c081ac74532509c3a238ee0113daaa1a2ea74e998bb75a233bf75ae9e1dfd47e220637926b4105c75c4f250dbaf10135b8d3190923c69a99b2228dca44a70403a22544ce0642e70335976e2fb35634a8837406f89682ee978956a90bcd05d9aef057abcb9608eaf4d4a5155e9a4228aaf413937735de68b763ef25b81f5f8889bfa00a49f9544e388f7a156ecd8b8f24c3c2b8efed51c20b232ac8be6d85c5a1575439eccd1c8899009da35381d36266b586be91aa20ce7fcaf9c7a1c7c78abd48969ba7a710a4fc255512dc6765b5998e93e5281ef895cf7f30522b3c34dd713f9c7e8f2535e92397dd3972f5c292117b16e1807b906090b03fd76fcbd850ae2e82e1baa7f90c516eee49eade50dd227b0b8bd987b8d1142fdfd374ff7bd6754133bfb83eaa6698faa1f23707ea30071e436ce323b1d17232b9f5dc907237c1facd6ba91046b7bfc87d93583d1462c67d53c27277e20d85df0712c64918f7cf627f2deadda1a1ad781f94793b04c61923994a38496d118034e21be27e598a4518fa11ed8dfbd55acd6c93fccd8fa152b4f922aca0248339c58db77cfef4d6ee4fcbccc7f4a6007bbfd4ffd4102419e89273371c8e34b812103fe490773f8623ed93be8502a4a324b3fa5df521076bcd505cdfcc114f737af69202f6fc4f8aca4674869841d4889d58d40496c06a50465b6aeb6c6c0e6b59addb383caf104781fa2a6f3189fe68497c2ee0715b42f81aa54e1a924ae3f01372d1b10b8c0d96ebbe013a077d358f5af9782fc25efe976f01fe0d5298831b87a2acf90f8cff77d8f15bc3bbcdc5f89d9c44fa40628b2abf4f889fb63704fad6c345fb6cb860d145e799324f50d6f8263877046b3f4f6573df16b1d3211b9042383b769115c7e78615a94e99734120cc63cf5faa57c05f5155ab9c5848aaf41208a8f40a28eaf4c48285f8b5c434dbc2b9c6bbb87d3270ab2be3f32805308c7a1f41eab42ca333c9337170a2f5e660192dfe0c01ace6397ad045291eaaa55a4cefa58360efb889b229b4349ef5e9e5048f7c15f3893c13f701e6c4926b68907974c03718f23cd341329c8ee269b4693e9bf639362d146ed37639171e660381ff485131d8a7ee4de240b45a8804cdc3f03e51b5d44d9c7a1d00677f4f95456b64b7bbb9ff5ba7d5398e838f0f5522b19b2b06e0866be4eff008755ba0ff503df7fad6554cddbc5deb8ab234eaa45e180ff001370de4b5c63b000dc46718f9a35476bc437fbbcc1f54a9ebd3c940794cbb5c5b336141e212003feeb43ab39db7ec3e7f5ad4b5c063c0c7badfd6a2a732399f45bdede14853248d56d72b9f9bc93a8f7f61b7e955dd17bbbf987d18111974f54dfc6f8a684980273f03683b7f3d97718fe6dfdb350b1a49698d5ff00a938ebd1407c51e639024ed195d45ac894d3ab2ad1be9db639fc2339f515a164a61e1a3735df47327d544f7413cfd0ae438f9a66b6e2664d2dff00ba5e1646c8cb03167503bf958e483df047ad6e9640be0106ed1eb9e5cf7f10744d26478abeb9379af169752791cbdb70e8d07f23c2eebabfedb646ed901beb50566f6cea6f2081ff00149e7dab5be189e7c90c81033c3c8a8cf3270c02cd1261d38a2e2b2de5c9c02c62ba92e52445519dd90c0013800e0fa014455687bcd3c5c58c89ca6886804f5911af89488c04fb9c557dcbdc9892c2aedb9cba67dc44ed10ee41ec83d2ae56dbf4ec751d404e04efd71f551760f7f79a305dd2ad596b1c222bd3514457a08a2ac94d4556be27cdd4bbb0833b1b9b76c7b9cccb81b8df0c36f5cd455096b1ce1f95de9f65a56518754dfcc3c662666092aa4b247224d6f303134fd49617468ba98490a4a842b2330658e720d4b4e996b0118e45a46912208ce0838e1996ab24e28c650489613866315c2e0e00f8b40b237f32c17620007a32b6724915728370bafe20ff006e20756de503b391efd94efc38b9b807cab86521909216198a5f5ae350193d41246d81b0206f51917865a1ea5a0b1d970823c51c8fbd7153de1f3e1edd7db88cd195dc6ce2dd31dbb6067e95835710efe9047495701cb9a90f84f36cc0b1ff0002df38cfa5c5efc86fe6c6ff00afa8b6360370d5de4c4a9e33d3d547f96df12db1f379afa53bec3f0da01b1c630cbbe2ac57c4380d037cdde85319a754d3c4e60c6dd5c77b1bd19276cfed8c323bfe32b82318207b0cd90dee973747b7c9be89b3e498648d34aae58e78648cd977c9d123f4c124ea3a34c417d542263f08c44dbcf7c9ff00987c8cfaf3c65126074fb2149c1e022595e356ff0086dbb36acb659268551b1fc4a3186c67f5cb034df606923bcfe1843fe980c3823381e43d1736f8c16711be57c2921f8396180753cf0a34e5cb0d45ae063a8c705bb9df7aeaac98d02d33176a1e576a80d8fe91f2eee4ab9743bdfe555a723738cd60c2d02f516616f2a966edf79711691e849320c63380a7df6ad54b5ae7ba302d761bbbcdf0c5b039a7913046ff004531e7cf1163beb04911fcd3c5722652ac02cb6b77a82a9230de48a3d2c09186c6c4361b6763457a8c6c436a54674871f187370df07284e3a4ee69f4fba75e5cf0c0bc41d9b1ada571b9194695d9180f6642ac3dc115cd5b2d553b53d98c21ba0cee89fac856e97ca3deabaf81ad85cb85b8341144534522880d31155df30da2bf13b466ee970ba7e440b4c1fa8d6dfd6a2aa486ba370fd4b56cc3ba13cf307088a783a73c692a14b95d2ea08c436a90c641ee1951db0e08604939dce6bd57b98ebed3041047525de7a64acb3bc20a8bd870b586dd224c858adaee25df7d30dac7791ea3eacb3c8cfabbf6fa9d4a154bcb5c6312dfabcb0f8b442ad51a1b80e3e52a55c0d75408e7bb4583f44ba2c807f97aaca3f9428f4c97d5370be37f9b31f29e68b718f7aa91db7fcc67ff009703fab91b67fca2b9fa9f2c7f27a1565b9f54fdc8274489a4e357449f4dd6eae8ae31fc24ea19cefef525acf76774ff00833cd260f7e2b58999a5b591d8b33ddccc490a37d36ee30aa15400703b761be4e497be3be00810df3235c50190ebe4a33c4ecd59532371c36e707d72d2dd64ff00bffc55c61323fee7e86a8ce5d3d542f88598d8e5c7fc209d9d80cea739d8fb9cd42e71103fea3bc9c9e0604f01e88bd322095f53923865b609763b9bab7193be0903b1f97ad43445e7b01fcd53e8da89eec8f4f45ce1e2b4ccbc4a08492ea472f3b16c6a62f68a5b3a428df00640071eb924d76b656dea05c732dadffde1517e67dfe154bf373652193f0b2c303065c820ff00783a6739f40685b698631d1a5f8e8e07cd4d4b1cfdf754962807f75f0e8fd1a5e324fb9d29148a33ec1a47dbf98fd6b268777b6a83e62f6fd45d3e200f04e7998e5eabe82f845c856b3f0bb09248f2df0b1479fe58544318fc92351f957206d752912d6c664e3c4927ea55e2c07e9e4bffd9, NULL, 2),
(4, 'Rohit ', 'Lawtawar', 'rohit.lawtawar@tejovat.com', 'rohit.lawatawar@tejovat.com', NULL, 'M', '12345678', 'Unit 12', 'Hinjewadi road', '411058', 'Pune', 'Madhya Pradesh', 'India', NULL, NULL, NULL, NULL, NULL, '7218030984', NULL, NULL, NULL, NULL, 1),
(5, 'Yogesh', 'Lokare', 'yogeshlokare7@gmail.com', 'yogeshlokare7@gmail.com', NULL, 'M', 'Pge2fy+g', 'Pune', 'Nigdi Road', '411058', 'Pune', 'Andhra Pradesh', 'India', NULL, NULL, NULL, NULL, NULL, '3465465465', NULL, NULL, NULL, NULL, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer_master`
--
ALTER TABLE `customer_master`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_invoice_customer_idx` (`customerid`);

--
-- Indexes for table `package_items`
--
ALTER TABLE `package_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_package_items_idx` (`packageid`);

--
-- Indexes for table `package_order`
--
ALTER TABLE `package_order`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `packageno_UNIQUE` (`packageno`),
  ADD UNIQUE KEY `shipmentno_UNIQUE` (`shipmentno`),
  ADD KEY `fk_salesorder_package_idx` (`salesorderno`);

--
-- Indexes for table `productitems`
--
ALTER TABLE `productitems`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_product_item_idx` (`productid`);

--
-- Indexes for table `productmaster`
--
ALTER TABLE `productmaster`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sales_items`
--
ALTER TABLE `sales_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_salesitems_salesorder_idx` (`salesorderid`),
  ADD KEY `fk_salesitems_product_idx` (`productid`),
  ADD KEY `fk_salesitems_item_idx` (`itemid`);

--
-- Indexes for table `sales_order`
--
ALTER TABLE `sales_order`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `salesorderno_UNIQUE` (`salesorderno`),
  ADD KEY `fk_salesorder_customer_idx` (`customerid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_role_idx` (`userrole`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer_master`
--
ALTER TABLE `customer_master`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `package_items`
--
ALTER TABLE `package_items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `package_order`
--
ALTER TABLE `package_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `productitems`
--
ALTER TABLE `productitems`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `productmaster`
--
ALTER TABLE `productmaster`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `sales_items`
--
ALTER TABLE `sales_items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `sales_order`
--
ALTER TABLE `sales_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `fk_invoice_customer` FOREIGN KEY (`customerid`) REFERENCES `customer_master` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `package_items`
--
ALTER TABLE `package_items`
  ADD CONSTRAINT `fk_package_items` FOREIGN KEY (`packageid`) REFERENCES `package_order` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `package_order`
--
ALTER TABLE `package_order`
  ADD CONSTRAINT `fk_package_sales` FOREIGN KEY (`salesorderno`) REFERENCES `sales_order` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `productitems`
--
ALTER TABLE `productitems`
  ADD CONSTRAINT `fk_product_item` FOREIGN KEY (`productid`) REFERENCES `productmaster` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `sales_items`
--
ALTER TABLE `sales_items`
  ADD CONSTRAINT `fk_salesitems_item` FOREIGN KEY (`itemid`) REFERENCES `productitems` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_salesitems_product` FOREIGN KEY (`productid`) REFERENCES `productmaster` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_salesitems_salesorder` FOREIGN KEY (`salesorderid`) REFERENCES `sales_order` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `sales_order`
--
ALTER TABLE `sales_order`
  ADD CONSTRAINT `fk_salesorder_customer` FOREIGN KEY (`customerid`) REFERENCES `customer_master` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_user_role` FOREIGN KEY (`userrole`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
