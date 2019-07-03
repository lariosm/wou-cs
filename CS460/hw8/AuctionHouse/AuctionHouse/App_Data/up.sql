--Sellers table
CREATE TABLE [dbo].[Sellers]
(
	[ID]	INT IDENTITY (1,1)	NOT NULL,
	[Name]	NVARCHAR(30)		NOT NULL,

	CONSTRAINT [PK_dbo.Sellers] PRIMARY KEY CLUSTERED (ID ASC),
);

--Buyers table
CREATE TABLE [dbo].[Buyers]
(
	[ID]	INT IDENTITY (1,1)	NOT NULL,
	[Name]	NVARCHAR(30)		NOT NULL,

	CONSTRAINT [PK_dbo.Buyers] PRIMARY KEY CLUSTERED (ID ASC),
);

--Items table
CREATE TABLE [dbo].[Items]
(
	[ID]			INT IDENTITY (1001,1)						NOT NULL,
	[Name]			NVARCHAR(100)								NOT NULL,
	[Description]	NVARCHAR(MAX)								NOT NULL,
	[SellerID]		INT											NOT NULL,

	CONSTRAINT [PK_dbo.Items] PRIMARY KEY CLUSTERED (ID ASC),
	CONSTRAINT [FK_dbo.Items] FOREIGN KEY (SellerID) REFERENCES [dbo].[Sellers] (ID)
);

--Bids table
CREATE TABLE [dbo].[Bids]
(
	[ID]			INT IDENTITY (1,1)							NOT NULL,
	[ItemID]		INT											NOT NULL,
	[BuyerID]		INT											NOT NULL,
	[Price]			INT											NOT NULL,
	[TimeStamp]		DATETIME									NOT NULL,

	CONSTRAINT [PK_dbo.Bids] PRIMARY KEY CLUSTERED (ID ASC),
	CONSTRAINT [FK_dbo.Bids] FOREIGN KEY (ItemID) REFERENCES [dbo].[Items] (ID),
	CONSTRAINT [FK2_dbo.Bids] FOREIGN KEY (BuyerID) REFERENCES [dbo].[Buyers] (ID),

);

--Seller seed data
INSERT INTO [dbo].[Sellers] (Name) VALUES
	('Gayle Hardy'),
	('Lyle Banks'),
	('Pearl Greene'),
	('Jen Brooks'),
	('Todd Young');

--Buyer seed data
INSERT INTO [dbo].[Buyers] (Name) VALUES
	('Jane Stone'),
	('Tom McMasters'),
	('Otto Vanderwall'),
	('John Smith'),
	('Emma Jones');

--Item seed data
INSERT INTO [dbo].[Items] (Name, Description, SellerID) VALUES
	('Abraham Lincoln Hammer', 'A bench mallet fashioned from a broken rail-splitting maul in 1829 and owned by Abraham Lincoln', 3),
	('Albert Einsteins Telescope', 'A brass telescope owned by Albert Einstein in Germany, circa 1927', 1),
	('Bob Dylan Love Poems', 'Five versions of an original unpublished, handwritten, love poem by Bob Dylan', 2);

--Bids seed data
INSERT INTO [dbo].[Bids] (ItemID, BuyerID, Price, TimeStamp) VALUES
	(1001, 1, 250000, '11/04/2018 09:04:22'),
	(1003, 3, 95000 ,'11/04/2018 08:44:03'),
	(1002, 2, 50000, '11/06/2018 17:11:34'),
	(1001, 4, 500000, '11/12/2018 21:26:01'),
	(1001, 1, 750000, '11/12/2018 21:31:44'),
	(1003, 5, 150000, '11/19/2018 08:22:51'),
	(1002, 4, 300000, '11/20/2018 21:26:01'),
	(1001, 4, 1000000, '11/21/2018 10:01:21');
