-- Tenants table
CREATE TABLE [dbo].[Tenants]
(
	[ID]			INT IDENTITY (1,1)	NOT NULL,
	[FirstName]		NVARCHAR(25)		NOT NULL,
	[LastName]	    NVARCHAR(35)		NOT NULL,
	[PhoneNumber]   NVARCHAR(12)		NOT NULL, 
    [ApartmentName] NVARCHAR(40)		NOT NULL, 
    [UnitNumber]	INT					NOT NULL, 
    [Description]	NVARCHAR(500)		NOT NULL, 
    [Checkbox]		BIT					NOT NULL, 
    [Received]		DATETIME			NULL
    CONSTRAINT [PK_dbo.Users] PRIMARY KEY CLUSTERED ([ID] ASC)
);

INSERT INTO [dbo].[Tenants] (FirstName, LastName, PhoneNumber, ApartmentName, UnitNumber, Description, Checkbox, Received) VALUES
		('Jim', 'Johnson', '503-999-8888', 'Alpha Apartments', 11, 'Stovetop is in need of repair', 0, '10-18-2018 02:30:18 PM'),
		('John', 'Schwartz', '503-777-5555', 'Woodland Apartments', 7, 'Heating element in dryer is broken', 1, '10-01-2018 10:08:32 AM'),
		('Kate', 'Ocean', '503-444-3333', 'Vista Apartments', 4, 'Mice infestation is out of control.', 1, '09-30-2018 07:44:09 PM'),
		('Suzy', 'Collins', '971-444-8888', 'Woodland Apartments', 16, 'Can we get a swing set for the playground?', 0, '10-13-2018 09:55:57 AM'),
		('John', 'Skeeter', '971-222-5555', 'Alpha Apartments', 3, 'Tired of asking neighbor to turn down the music.', 1, '09-22-2018 10:12:07 PM')
GO